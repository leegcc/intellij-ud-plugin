package com.usooft.idea.plugin.ud.lang.folding;

import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.FoldingBuilderEx;
import com.intellij.lang.folding.FoldingDescriptor;
import com.intellij.openapi.editor.Document;
import com.intellij.psi.PsiElement;
import com.usooft.idea.plugin.ud.lang.psi.UMEntityDeclaration;
import com.usooft.idea.plugin.ud.lang.psi.UMEnumDeclaration;
import com.usooft.idea.plugin.ud.lang.psi.UMMethodsBlock;
import com.usooft.idea.plugin.ud.lang.psi.UMRelationsBlock;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class UMFoldingBuilder extends FoldingBuilderEx {
    @NotNull
    @Override
    public FoldingDescriptor[] buildFoldRegions(@NotNull PsiElement root, @NotNull Document document, boolean quick) {
        List<FoldingDescriptor> descriptors = new ArrayList<>();
        collectFoldRegions(root, descriptors);
        return descriptors.toArray(new FoldingDescriptor[0]);
    }

    private void collectFoldRegions(@NotNull PsiElement element, List<FoldingDescriptor> descriptors) {
        if (element instanceof UMEntityDeclaration || element instanceof UMEnumDeclaration ||
            element instanceof UMMethodsBlock || element instanceof UMRelationsBlock) {
            descriptors.add(new FoldingDescriptor(element.getNode(), element.getTextRange()));
        }

        for (PsiElement child : element.getChildren()) {
            collectFoldRegions(child, descriptors);
        }
    }

    @Nullable
    @Override
    public String getPlaceholderText(@NotNull ASTNode node) {
        PsiElement psi = node.getPsi();
        if (psi instanceof UMEntityDeclaration) {
            return "entity " + ((UMEntityDeclaration) psi).getName() + " {...}";
        } else if (psi instanceof UMEnumDeclaration) {
            return "enum " + ((UMEnumDeclaration) psi).getName() + " {...}";
        } else if (psi instanceof UMMethodsBlock) {
            return "@@methods {...}";
        } else if (psi instanceof UMRelationsBlock) {
            return "@@relations {...}";
        }
        return "...";
    }

    @Override
    public boolean isCollapsedByDefault(@NotNull ASTNode node) {
        return false;
    }
}