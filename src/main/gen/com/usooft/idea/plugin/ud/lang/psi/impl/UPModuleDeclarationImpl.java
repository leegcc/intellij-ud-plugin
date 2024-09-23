// This is a generated file. Not intended for manual editing.
package com.usooft.idea.plugin.ud.lang.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.usooft.idea.plugin.ud.lang.psi.UPTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.usooft.idea.plugin.ud.lang.psi.*;

public class UPModuleDeclarationImpl extends ASTWrapperPsiElement implements UPModuleDeclaration {

  public UPModuleDeclarationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull UPVisitor visitor) {
    visitor.visitModuleDeclaration(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof UPVisitor) accept((UPVisitor)visitor);
    else super.accept(visitor);
  }

}
