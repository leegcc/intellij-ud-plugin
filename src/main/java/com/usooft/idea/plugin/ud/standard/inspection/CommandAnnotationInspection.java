package com.usooft.idea.plugin.ud.standard.inspection;

import com.intellij.codeInspection.AbstractBaseJavaLocalInspectionTool;
import com.intellij.codeInspection.InspectionManager;
import com.intellij.codeInspection.ProblemDescriptor;
import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.psi.PsiAnnotation;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiMethod;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class CommandAnnotationInspection extends AbstractBaseJavaLocalInspectionTool {

    @Override
    public @Nullable ProblemDescriptor[] checkClass(@NotNull PsiClass psiClass,
                                                    @NotNull InspectionManager manager,
                                                    boolean isOnTheFly) {
        PsiAnnotation commandAnnotation = psiClass.getAnnotation("com.usooft.ud.runtime.command.Command");
        if (commandAnnotation != null) {
            PsiMethod[] methods = psiClass.getMethods();

            boolean hasExecuteMethod = false;
            for (PsiMethod method : methods) {
                if ("execute".equals(method.getName())) {
                    hasExecuteMethod = true;
                    break;
                }
            }

            if (!hasExecuteMethod) {
                ProblemDescriptor problem = manager.createProblemDescriptor(
                        Objects.requireNonNull(psiClass.getNameIdentifier()),
                        "Class annotated with @Command must contain an execute() method",
                        new AddExecuteMethodQuickFix(),
                        ProblemHighlightType.ERROR,
                        isOnTheFly
                );
                return new ProblemDescriptor[]{problem};
            }
        }
        return ProblemDescriptor.EMPTY_ARRAY;
    }
}