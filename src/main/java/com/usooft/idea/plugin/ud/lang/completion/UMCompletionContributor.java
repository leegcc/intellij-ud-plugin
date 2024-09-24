package com.usooft.idea.plugin.ud.lang.completion;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.ProcessingContext;
import com.usooft.idea.plugin.ud.lang.UMLanguage;
import com.usooft.idea.plugin.ud.lang.psi.*;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UMCompletionContributor extends CompletionContributor {
    public UMCompletionContributor() {
        extend(
                CompletionType.BASIC,
                PlatformPatterns.psiElement()
                        .withLanguage(UMLanguage.INSTANCE),
                new CompletionProvider<>() {
                    @Override
                    protected void addCompletions(@NotNull CompletionParameters parameters,
                                                  @NotNull ProcessingContext context,
                                                  @NotNull CompletionResultSet result) {
                        System.out.println(parameters.getPosition() + ", parent: " + parameters.getPosition().getParent());
                    }
                }
        );

        // filter 的补全
        extend(
                CompletionType.BASIC,
                PlatformPatterns.psiElement()
                        .withParent(UMAttributeValueReference.class)
                        .withLanguage(UMLanguage.INSTANCE),
                new CompletionProvider<>() {
                    @Override
                    protected void addCompletions(@NotNull CompletionParameters parameters,
                                                  @NotNull ProcessingContext context,
                                                  @NotNull CompletionResultSet result) {
                        UMAttributeParams attributeParams = PsiTreeUtil.getParentOfType(
                                parameters.getPosition(),
                                UMAttributeParams.class
                        );
                        if (attributeParams != null) {
                            String attributeName = attributeParams
                                    .getPrevSibling()
                                    .getFirstChild()
                                    .getText();
                            if (attributeName.equals("filter")) {
                                UMFieldType fieldType = PsiTreeUtil.getChildOfType(PsiTreeUtil.getParentOfType(
                                        parameters.getPosition(),
                                        UMFieldDeclaration.class
                                ), UMFieldType.class);
                                if (fieldType == null) {
                                    return;
                                }
                                String typeName = fieldType.getFirstChild().getText();
                                List<LookupElementBuilder> filterOptions = new ArrayList<>();

                                // 适用于所有类型的过滤方式
                                filterOptions.add(LookupElementBuilder.create("EQ").withTypeText("eq"));
                                filterOptions.add(LookupElementBuilder.create("NOT_EQ").withTypeText("notEq"));
                                filterOptions.add(LookupElementBuilder.create("IN").withTypeText("in"));
                                filterOptions.add(LookupElementBuilder.create("NOT_IN").withTypeText("notIn"));
                                filterOptions.add(LookupElementBuilder.create("IS_NULL").withTypeText("isNull"));
                                filterOptions.add(LookupElementBuilder.create("IS_NOT_NULL").withTypeText("isNotNull"));

                                // 适用于 Int, DateTime, Decimal 类型的过滤方式
                                if (typeName.equals("Int") || typeName.equals("DateTime") || typeName.equals("Decimal")) {
                                    filterOptions.add(LookupElementBuilder.create("LT").withTypeText("lt"));
                                    filterOptions.add(LookupElementBuilder.create("LTE").withTypeText("lte"));
                                    filterOptions.add(LookupElementBuilder.create("GT").withTypeText("gt"));
                                    filterOptions.add(LookupElementBuilder.create("GTE").withTypeText("gte"));
                                }

                                // 适用于 String 类型的过滤方式
                                if (typeName.equals("String")) {
                                    filterOptions.add(LookupElementBuilder.create("LIKE").withTypeText("Like"));
                                    filterOptions.add(LookupElementBuilder.create("NOT_LIKE").withTypeText("notLike"));
                                    filterOptions.add(LookupElementBuilder.create("CONTAINS").withTypeText("contains"));
                                    filterOptions.add(LookupElementBuilder.create("NOT_CONTAINS").withTypeText("notContains"));
                                    filterOptions.add(LookupElementBuilder.create("STARTS").withTypeText("startsWith"));
                                    filterOptions.add(LookupElementBuilder.create("NOT_STARTS").withTypeText("notStartsWith"));
                                    filterOptions.add(LookupElementBuilder.create("ENDS").withTypeText("endsWith"));
                                    filterOptions.add(LookupElementBuilder.create("NOT_ENDS").withTypeText("notEndsWith"));
                                }

                                // 过滤掉已存在的过滤方式
                                Set<String> existingFilters = PsiTreeUtil.findChildrenOfType(
                                        attributeParams,
                                        UMAttributeValueReference.class
                                ).stream().map(UMAttributeValueReference::getText).collect(Collectors.toSet());
                                List<LookupElementBuilder> filteredOptions = filterOptions.stream()
                                        .filter(option -> !existingFilters.contains(option.getLookupString()))
                                        .collect(Collectors.toList());
                                Collections.reverse(filteredOptions);
                                result.caseInsensitive().addAllElements(filteredOptions);
                            }
                        }
                    }
                }
        );

        extend(
                CompletionType.BASIC,
                PlatformPatterns.psiElement()
                        .withParent(UMAttributeName.class)
                        .withLanguage(UMLanguage.INSTANCE),
                new CompletionProvider<>() {
                    @Override
                    protected void addCompletions(@NotNull CompletionParameters parameters,
                                                  @NotNull ProcessingContext context,
                                                  @NotNull CompletionResultSet result) {
                        result.addElement(LookupElementBuilder.create("id"));
                        result.addElement(LookupElementBuilder.create("key"));
                        result.addElement(LookupElementBuilder.create("createdAt"));
                        result.addElement(LookupElementBuilder.create("updatedAt"));
                        result.addElement(LookupElementBuilder.create("state")
                                .withInsertHandler((insertContext, item) -> {
                                    insertContext.getDocument().insertString(insertContext.getTailOffset(), "()");
                                    insertContext.getEditor().getCaretModel().moveToOffset(insertContext.getTailOffset() - 1);
                                }));
                        result.addElement(LookupElementBuilder.create("version"));
                        result.addElement(LookupElementBuilder.create("password"));
                        result.addElement(LookupElementBuilder.create("range")
                                .withInsertHandler((insertContext, item) -> {
                                    insertContext.getDocument().insertString(insertContext.getTailOffset(), "()");
                                    insertContext.getEditor().getCaretModel().moveToOffset(insertContext.getTailOffset() - 1);
                                }));
                        result.addElement(LookupElementBuilder.create("pattern")
                                .withInsertHandler((insertContext, item) -> {
                                    insertContext.getDocument().insertString(insertContext.getTailOffset(), "(//)");
                                    insertContext.getEditor().getCaretModel().moveToOffset(insertContext.getTailOffset() - 2);
                                }));
                        result.addElement(LookupElementBuilder.create("index"));
                        result.addElement(LookupElementBuilder.create("unique"));
                        result.addElement(LookupElementBuilder.create("sortable"));
                        result.addElement(LookupElementBuilder.create("filter")
                                .withInsertHandler((insertContext, item) -> {
                                    insertContext.getDocument().insertString(insertContext.getTailOffset(), "()");
                                    insertContext.getEditor().getCaretModel().moveToOffset(insertContext.getTailOffset() - 1);
                                }));
                        result.addElement(LookupElementBuilder.create("secret"));
                        result.addElement(LookupElementBuilder.create("initial")
                                .withInsertHandler((insertContext, item) -> {
                                    insertContext.getDocument().insertString(insertContext.getTailOffset(), "()");
                                    insertContext.getEditor().getCaretModel().moveToOffset(insertContext.getTailOffset() - 1);
                                }));
                        result.addElement(LookupElementBuilder.create("computed")
                                .withInsertHandler((insertContext, item) -> {
                                    insertContext.getDocument().insertString(insertContext.getTailOffset(), "()");
                                    insertContext.getEditor().getCaretModel().moveToOffset(insertContext.getTailOffset() - 1);
                                }));
                        result.addElement(LookupElementBuilder.create("nullable"));
                        result.addElement(LookupElementBuilder.create("mutable"));
                        result.addElement(LookupElementBuilder.create("mutable.once"));
                        result.addElement(LookupElementBuilder.create("aggr")
                                .withInsertHandler((insertContext, item) -> {
                                    insertContext.getDocument().insertString(insertContext.getTailOffset(), "()");
                                    insertContext.getEditor().getCaretModel().moveToOffset(insertContext.getTailOffset() - 1);
                                }));
                        result.addElement(LookupElementBuilder.create("aggr.having")
                                .withInsertHandler((insertContext, item) -> {
                                    insertContext.getDocument().insertString(insertContext.getTailOffset(), "()");
                                    insertContext.getEditor().getCaretModel().moveToOffset(insertContext.getTailOffset() - 1);
                                }));
                        result.addElement(LookupElementBuilder.create("aggr.group"));
                        result.addElement(LookupElementBuilder.create("aggr.sortable"));
                        result.addElement(LookupElementBuilder.create("db.varchar")
                                .withInsertHandler((insertContext, item) -> {
                                    insertContext.getDocument().insertString(insertContext.getTailOffset(), "()");
                                    insertContext.getEditor().getCaretModel().moveToOffset(insertContext.getTailOffset() - 1);
                                }));
                        result.addElement(LookupElementBuilder.create("db.text"));
                        result.addElement(LookupElementBuilder.create("db.bigint"));
                        result.addElement(LookupElementBuilder.create("db.decimal")
                                .withInsertHandler((insertContext, item) -> {
                                    insertContext.getDocument().insertString(insertContext.getTailOffset(), "()");
                                    insertContext.getEditor().getCaretModel().moveToOffset(insertContext.getTailOffset() - 1);
                                }));
                        result.addElement(LookupElementBuilder.create("db.column")
                                .withInsertHandler((insertContext, item) -> {
                                    insertContext.getDocument().insertString(insertContext.getTailOffset(), "()");
                                    insertContext.getEditor().getCaretModel().moveToOffset(insertContext.getTailOffset() - 1);
                                }));
                    }
                }
        );
    }
}