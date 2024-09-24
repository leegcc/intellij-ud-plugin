package com.usooft.idea.plugin.ud.lang.completion;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiErrorElement;
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

        // entity 关键词的补全
        extend(
                CompletionType.BASIC,
                PlatformPatterns.psiElement()
                        .withParent(PsiErrorElement.class)
                        .withLanguage(UMLanguage.INSTANCE),
                new CompletionProvider<>() {
                    @Override
                    protected void addCompletions(@NotNull CompletionParameters parameters,
                                                  @NotNull ProcessingContext context,
                                                  @NotNull CompletionResultSet result) {
                        List<LookupElementBuilder> typeOptions = new ArrayList<>();
                        typeOptions.add(LookupElementBuilder.create("entity"));
                        result.addAllElements(typeOptions);
                    }
                }
        );

        // 字段类型的补全
        extend(
                CompletionType.BASIC,
                PlatformPatterns.psiElement()
                        .withParent(UMFieldType.class)
                        .withLanguage(UMLanguage.INSTANCE),
                new CompletionProvider<>() {
                    @Override
                    protected void addCompletions(@NotNull CompletionParameters parameters,
                                                  @NotNull ProcessingContext context,
                                                  @NotNull CompletionResultSet result) {
                        List<LookupElementBuilder> typeOptions = new ArrayList<>();
                        typeOptions.add(LookupElementBuilder.create("Int").withTypeText("整数"));
                        typeOptions.add(LookupElementBuilder.create("String").withTypeText("字符串"));
                        typeOptions.add(LookupElementBuilder.create("DateTime").withTypeText("日期时间"));
                        typeOptions.add(LookupElementBuilder.create("Boolean").withTypeText("布尔值"));
                        typeOptions.add(LookupElementBuilder.create("Decimal").withTypeText("小数"));
                        result.addAllElements(typeOptions);
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
                            UMFieldType fieldType = PsiTreeUtil.getChildOfType(PsiTreeUtil.getParentOfType(
                                    parameters.getPosition(),
                                    UMFieldDeclaration.class
                            ), UMFieldType.class);
                            if (fieldType == null) {
                                return;
                            }
                            String typeName = fieldType.getFirstChild().getText();

                            String attributeName = attributeParams
                                    .getPrevSibling()
                                    .getText();
                            switch (attributeName) {
                                case "@filter" -> {
                                    List<LookupElementBuilder> filterOptions = new ArrayList<>();

                                    // 适用于所有类型的过滤方式
                                    filterOptions.add(LookupElementBuilder.create("EQ").withTypeText("等于"));
                                    filterOptions.add(LookupElementBuilder.create("NOT_EQ").withTypeText("不等于"));
                                    filterOptions.add(LookupElementBuilder.create("IN").withTypeText("包含"));
                                    filterOptions.add(LookupElementBuilder.create("NOT_IN").withTypeText("不包含"));
                                    filterOptions.add(LookupElementBuilder.create("IS_NULL").withTypeText("为空"));
                                    filterOptions.add(LookupElementBuilder.create("IS_NOT_NULL").withTypeText("不为空"));

                                    // 适用于 Int, DateTime, Decimal 类型的过滤方式
                                    if (typeName.equals("Int") || typeName.equals("DateTime") || typeName.equals("Decimal")) {
                                        filterOptions.add(LookupElementBuilder.create("LT").withTypeText("小于"));
                                        filterOptions.add(LookupElementBuilder.create("LTE").withTypeText("小于等于"));
                                        filterOptions.add(LookupElementBuilder.create("GT").withTypeText("大于"));
                                        filterOptions.add(LookupElementBuilder.create("GTE").withTypeText("大于等于"));
                                    }

                                    // 适用于 String 类型的过滤方式
                                    if (typeName.equals("String")) {
                                        filterOptions.add(LookupElementBuilder.create("LIKE").withTypeText("模糊匹配"));
                                        filterOptions.add(LookupElementBuilder.create("NOT_LIKE").withTypeText("不匹配"));
                                        filterOptions.add(LookupElementBuilder.create("CONTAINS").withTypeText("包含"));
                                        filterOptions.add(LookupElementBuilder.create("NOT_CONTAINS").withTypeText("不包含"));
                                        filterOptions.add(LookupElementBuilder.create("STARTS").withTypeText("以...开始"));
                                        filterOptions.add(LookupElementBuilder.create("NOT_STARTS").withTypeText("不以...开始"));
                                        filterOptions.add(LookupElementBuilder.create("ENDS").withTypeText("以...结束"));
                                        filterOptions.add(LookupElementBuilder.create("NOT_ENDS").withTypeText("不以...结束"));
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
                                case "@aggr.having" -> {
                                    List<LookupElementBuilder> aggrHavingOptions = new ArrayList<>();

                                    // 适用于所有类型的聚合过滤方式
                                    aggrHavingOptions.add(LookupElementBuilder.create("EQ").withTypeText("等值"));
                                    aggrHavingOptions.add(LookupElementBuilder.create("NOT_EQ").withTypeText("不等值"));
                                    aggrHavingOptions.add(LookupElementBuilder.create("IN").withTypeText("在范围内"));
                                    aggrHavingOptions.add(LookupElementBuilder.create("NOT_IN").withTypeText("不在范围内"));

                                    // 适用于 Int, Decimal 类型的聚合过滤方式
                                    if (typeName.equals("Int") || typeName.equals("Decimal")) {
                                        aggrHavingOptions.add(LookupElementBuilder.create("LT").withTypeText("小于"));
                                        aggrHavingOptions.add(LookupElementBuilder.create("LTE").withTypeText("小于等于"));
                                        aggrHavingOptions.add(LookupElementBuilder.create("GT").withTypeText("大于"));
                                        aggrHavingOptions.add(LookupElementBuilder.create("GTE").withTypeText("大于等于"));
                                    }

                                    // 过滤掉已存在的聚合过滤方式
                                    Set<String> existingAggrHavings = PsiTreeUtil.findChildrenOfType(
                                            attributeParams,
                                            UMAttributeValueReference.class
                                    ).stream().map(UMAttributeValueReference::getText).collect(Collectors.toSet());
                                    List<LookupElementBuilder> filteredAggrHavingOptions = aggrHavingOptions.stream()
                                            .filter(option -> !existingAggrHavings.contains(option.getLookupString()))
                                            .collect(Collectors.toList());
                                    Collections.reverse(filteredAggrHavingOptions);
                                    result.caseInsensitive().addAllElements(filteredAggrHavingOptions);
                                }
                                case "@aggr" -> {
                                    List<LookupElementBuilder> aggrOptions = new ArrayList<>();

                                    // 适用于所有类型的聚合方式
                                    aggrOptions.add(LookupElementBuilder.create("DISTINCT_COUNT").withTypeText("去重计数"));
                                    aggrOptions.add(LookupElementBuilder.create("COUNT").withTypeText("计数"));

                                    // 适用于 Int, Decimal 类型的聚合方式
                                    if (typeName.equals("Int") || typeName.equals("Decimal")) {
                                        aggrOptions.add(LookupElementBuilder.create("SUM").withTypeText("求和"));
                                        aggrOptions.add(LookupElementBuilder.create("AVG").withTypeText("平均值"));
                                    }

                                    // 适用于 Int, Decimal, DateTime 类型的聚合方式
                                    if (typeName.equals("Int") || typeName.equals("Decimal") || typeName.equals("DateTime")) {
                                        aggrOptions.add(LookupElementBuilder.create("MIN").withTypeText("最小值"));
                                        aggrOptions.add(LookupElementBuilder.create("MAX").withTypeText("最大值"));
                                    }

                                    // 过滤掉已存在的聚合方式
                                    Set<String> existingAggrs = PsiTreeUtil.findChildrenOfType(
                                            attributeParams,
                                            UMAttributeValueReference.class
                                    ).stream().map(UMAttributeValueReference::getText).collect(Collectors.toSet());
                                    List<LookupElementBuilder> filteredAggrOptions = aggrOptions.stream()
                                            .filter(option -> !existingAggrs.contains(option.getLookupString()))
                                            .collect(Collectors.toList());
                                    Collections.reverse(filteredAggrOptions);
                                    result.caseInsensitive().addAllElements(filteredAggrOptions);
                                }
                                case "@aggr.group" -> {
                                    List<LookupElementBuilder> groupOptions = new ArrayList<>();

                                    // 适用于 DateTime 类型的分组方式
                                    if (typeName.equals("DateTime")) {
                                        groupOptions.add(LookupElementBuilder.create("YEAR").withTypeText("年"));
                                        groupOptions.add(LookupElementBuilder.create("MONTH").withTypeText("月"));
                                        groupOptions.add(LookupElementBuilder.create("DAY").withTypeText("日"));
                                        groupOptions.add(LookupElementBuilder.create("HOUR").withTypeText("时"));
                                        groupOptions.add(LookupElementBuilder.create("MINUTE").withTypeText("分"));
                                        groupOptions.add(LookupElementBuilder.create("SECOND").withTypeText("秒"));
                                    }

                                    // 过滤掉已存在的分组方式
                                    Set<String> existingGroups = PsiTreeUtil.findChildrenOfType(
                                            attributeParams,
                                            UMAttributeValueReference.class
                                    ).stream().map(UMAttributeValueReference::getText).collect(Collectors.toSet());
                                    List<LookupElementBuilder> filteredGroupOptions = groupOptions.stream()
                                            .filter(option -> !existingGroups.contains(option.getLookupString()))
                                            .collect(Collectors.toList());
                                    Collections.reverse(filteredGroupOptions);
                                    result.caseInsensitive().addAllElements(filteredGroupOptions);
                                }
                            } 
                        }
                    }
                }
        );

        extend(
                CompletionType.BASIC,
                PlatformPatterns.psiElement()
                        .withParent(UMAttribute.class)
                        .withLanguage(UMLanguage.INSTANCE),
                new CompletionProvider<>() {
                    @Override
                    protected void addCompletions(@NotNull CompletionParameters parameters,
                                                  @NotNull ProcessingContext context,
                                                  @NotNull CompletionResultSet result) {
                        // 获取当前输入位置的文本
                        String currentText = parameters.getPosition().getText();
                        boolean startsWithAt = currentText.startsWith("@");

                        // 获取已有的 attribute 名称
                        Set<String> existingAttributes = PsiTreeUtil.findChildrenOfType(
                                parameters.getPosition().getParent().getParent(),
                                UMAttribute.class
                        ).stream().map(attr -> attr.getFirstChild().getText()).collect(Collectors.toSet());
                        System.out.println(existingAttributes);

                        List<LookupElementBuilder> attributeOptions = new ArrayList<>();

                        // 添加所有可能的 attribute，但排除已存在的
                        if (!existingAttributes.contains("@id")) {
                            addAttribute(attributeOptions, "@id", "唯一标识符", startsWithAt);
                        }
                        if (!existingAttributes.contains("@key")) {
                            addAttribute(attributeOptions, "@key", "关联字段", startsWithAt);
                        }
                        if (!existingAttributes.contains("@createdAt")) {
                            addAttribute(attributeOptions, "@createdAt", "创建时间", startsWithAt);
                        }
                        if (!existingAttributes.contains("@updatedAt")) {
                            addAttribute(attributeOptions, "@updatedAt", "更新时间", startsWithAt);
                        }
                        if (!existingAttributes.contains("@state")) {
                            addAttributeWithParentheses(attributeOptions, "@state", "状态字段", startsWithAt);
                        }
                        if (!existingAttributes.contains("@version")) {
                            addAttribute(attributeOptions, "@version", "版本字段", startsWithAt);
                        }
                        if (!existingAttributes.contains("@password")) {
                            addAttribute(attributeOptions, "@password", "密码字段", startsWithAt);
                        }
                        if (!existingAttributes.contains("@range")) {
                            addAttributeWithParentheses(attributeOptions, "@range", "取值范围", startsWithAt);
                        }
                        if (!existingAttributes.contains("@pattern")) {
                            addAttributeWithRegex(attributeOptions, "@pattern", "取值模式", startsWithAt);
                        }
                        if (!existingAttributes.contains("@index")) {
                            addAttribute(attributeOptions, "@index", "索引", startsWithAt);
                        }
                        if (!existingAttributes.contains("@unique")) {
                            addAttribute(attributeOptions, "@unique", "唯一值", startsWithAt);
                        }
                        if (!existingAttributes.contains("@sortable")) {
                            addAttribute(attributeOptions, "@sortable", "支持排序", startsWithAt);
                        }
                        if (!existingAttributes.contains("@filter")) {
                            addAttributeWithParentheses(attributeOptions, "@filter", "支持过滤", startsWithAt);
                        }
                        if (!existingAttributes.contains("@secret")) {
                            addAttribute(attributeOptions, "@secret", "保密字段", startsWithAt);
                        }
                        if (!existingAttributes.contains("@initial")) {
                            addAttributeWithParentheses(attributeOptions, "@initial", "初始值", startsWithAt);
                        }
                        if (!existingAttributes.contains("@computed")) {
                            addAttributeWithParentheses(attributeOptions, "@computed", "计算字段", startsWithAt);
                        }
                        if (!existingAttributes.contains("@nullable")) {
                            addAttribute(attributeOptions, "@nullable", "可为空", startsWithAt);
                        }
                        if (!existingAttributes.contains("@mutable")) {
                            addAttribute(attributeOptions, "@mutable", "可修改", startsWithAt);
                        }
                        if (!existingAttributes.contains("@mutable.once")) {
                            addAttribute(attributeOptions, "@mutable.once", "仅可修改一次", startsWithAt);
                        }
                        if (!existingAttributes.contains("@aggr")) {
                            addAttributeWithParentheses(attributeOptions, "@aggr", "支持聚合", startsWithAt);
                        }
                        if (!existingAttributes.contains("@aggr.having")) {
                            addAttributeWithParentheses(attributeOptions, "@aggr.having", "聚合过滤", startsWithAt);
                        }
                        if (!existingAttributes.contains("@aggr.group")) {
                            addAttribute(attributeOptions, "@aggr.group", "聚合分组", startsWithAt);
                        }
                        if (!existingAttributes.contains("@aggr.sortable")) {
                            addAttribute(attributeOptions, "@aggr.sortable", "聚合排序", startsWithAt);
                        }
                        if (!existingAttributes.contains("@db.varchar")) {
                            addAttributeWithParentheses(attributeOptions, "@db.varchar", "VARCHAR 类型", startsWithAt);
                        }
                        if (!existingAttributes.contains("@db.text")) {
                            addAttribute(attributeOptions, "@db.text", "TEXT 类型", startsWithAt);
                        }
                        if (!existingAttributes.contains("@db.bigint")) {
                            addAttribute(attributeOptions, "@db.bigint", "BIGINT 类型", startsWithAt);
                        }
                        if (!existingAttributes.contains("@db.decimal")) {
                            addAttributeWithParentheses(attributeOptions, "@db.decimal", "DECIMAL 类型", startsWithAt);
                        }
                        if (!existingAttributes.contains("@db.column")) {
                            addAttributeWithParentheses(attributeOptions, "@db.column", "数据库列名", startsWithAt);
                        }

                        result.addAllElements(attributeOptions);
                    }

                    private void addAttribute(List<LookupElementBuilder> options, String name, String typeText, boolean startsWithAt) {
                        options.add(LookupElementBuilder.create(startsWithAt ? name.substring(1) : name).withTypeText(typeText));
                    }

                    private void addAttributeWithParentheses(List<LookupElementBuilder> options, String name, String typeText, boolean startsWithAt) {
                        options.add(LookupElementBuilder.create(startsWithAt ? name.substring(1) : name)
                                .withTypeText(typeText)
                                .withInsertHandler((insertContext, item) -> {
                                    insertContext.getDocument().insertString(insertContext.getTailOffset(), "()");
                                    insertContext.getEditor().getCaretModel().moveToOffset(insertContext.getTailOffset() - 1);
                                }));
                    }

                    private void addAttributeWithRegex(List<LookupElementBuilder> options, String name, String typeText, boolean startsWithAt) {
                        options.add(LookupElementBuilder.create(startsWithAt ? name.substring(1) : name)
                                .withTypeText(typeText)
                                .withInsertHandler((insertContext, item) -> {
                                    insertContext.getDocument().insertString(insertContext.getTailOffset(), "(//)");
                                    insertContext.getEditor().getCaretModel().moveToOffset(insertContext.getTailOffset() - 2);
                                }));
                    }
                }
        );
    }
}