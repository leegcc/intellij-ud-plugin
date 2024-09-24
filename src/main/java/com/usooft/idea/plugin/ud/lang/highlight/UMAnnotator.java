package com.usooft.idea.plugin.ud.lang.highlight;

import com.intellij.lang.ASTNode;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import com.usooft.idea.plugin.ud.lang.psi.*;
import org.jetbrains.annotations.NotNull;

public class UMAnnotator implements Annotator {

    @Override
    public void annotate(@NotNull final PsiElement element, @NotNull AnnotationHolder holder) {
        ASTNode node = element.getNode();
        IElementType elementType = node.getElementType();
        PsiElement parentElement = element.getParent();

        // 对方法中的符号进行高亮
        if ((elementType == UMTypes.QUESTION
             || elementType == UMTypes.PLUS
             || elementType == UMTypes.MINUS) && parentElement instanceof UMMethodParam) {
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(element.getTextRange())
                    .textAttributes(UMSyntaxHighlighter.METHOD_SYMBOL)
                    .create();
            return;
        }

        // 方法名
        if (elementType == UMTypes.METHOD_NAME) {
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(element.getTextRange())
                    .textAttributes(UMSyntaxHighlighter.METHOD_NAME)
                    .create();
            return;
        }

        if (elementType == UMTypes.RELATIONS_KEYWORD) {
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(element.getTextRange())
                    .textAttributes(UMSyntaxHighlighter.KEYWORD)
                    .create();
        } else if (elementType == UMTypes.METHODS_KEYWORD) {
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(element.getTextRange())
                    .textAttributes(UMSyntaxHighlighter.KEYWORD)
                    .create();
        } else if (element instanceof UMFieldType) {
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(element.getTextRange())
                    .textAttributes(UMSyntaxHighlighter.FIELD_TYPE)
                    .create();
        } else if (elementType == UMTypes.IDENTIFIER
                   && parentElement.getNode().getElementType() == UMTypes.FIELD_DECLARATION) {
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(element.getTextRange())
                    .textAttributes(UMSyntaxHighlighter.FIELD_NAME)
                    .create();
        } else if (elementType == UMTypes.IDENTIFIER
                   && parentElement.getNode().getElementType() == UMTypes.ENUM_VALUE) {
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(element.getTextRange())
                    .textAttributes(UMSyntaxHighlighter.FIELD_NAME)
                    .create();
        } else if (elementType == UMTypes.RELATION_NAME) {
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(element.getTextRange())
                    .textAttributes(UMSyntaxHighlighter.FIELD_NAME)
                    .create();
        }
    }
}