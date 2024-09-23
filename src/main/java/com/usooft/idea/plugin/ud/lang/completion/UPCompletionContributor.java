package com.usooft.idea.plugin.ud.lang.completion;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiErrorElement;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

public class UPCompletionContributor extends CompletionContributor {
    public UPCompletionContributor() {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement().withParent(PsiErrorElement.class),
                new CompletionProvider<>() {
                    @Override
                    protected void addCompletions(@NotNull CompletionParameters parameters,
                                                  @NotNull ProcessingContext context,
                                                  @NotNull CompletionResultSet result) {
                        result.addElement(LookupElementBuilder.create("module "));
                    }
                }
        );
    }
}