package com.usooft.idea.plugin.ud.standard.inspection;

import com.intellij.codeInspection.LocalQuickFix;
import com.intellij.codeInspection.ProblemDescriptor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import org.jetbrains.annotations.NotNull;

public class AddExecuteMethodQuickFix implements LocalQuickFix {

    @Override
    public @NotNull String getName() {
        return "Add execute() method";
    }

    @Override
    public @NotNull String getFamilyName() {
        return getName();
    }

    @Override
    public void applyFix(@NotNull Project project, @NotNull ProblemDescriptor descriptor) {
        PsiElement element = descriptor.getPsiElement();
        PsiClass psiClass = null;

        if (element instanceof PsiClass) {
            psiClass = (PsiClass) element;
        } else if (element instanceof PsiIdentifier) {
            PsiElement parent = element.getParent();
            if (parent instanceof PsiClass) {
                psiClass = (PsiClass) parent;
            }
        }

        if (psiClass != null) {
            PsiElementFactory factory = JavaPsiFacade.getElementFactory(project);
            PsiMethod executeMethod = factory.createMethodFromText(
                    "public void execute() {\n    \n}",
                    psiClass
            );
            psiClass.add(executeMethod);
        }
    }
}