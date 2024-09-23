// This is a generated file. Not intended for manual editing.
package com.usooft.idea.plugin.ud.lang.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.usooft.idea.plugin.ud.lang.psi.UMTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.usooft.idea.plugin.ud.lang.psi.*;

public class UMStatusTransactionImpl extends ASTWrapperPsiElement implements UMStatusTransaction {

  public UMStatusTransactionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull UMVisitor visitor) {
    visitor.visitStatusTransaction(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof UMVisitor) accept((UMVisitor)visitor);
    else super.accept(visitor);
  }

}
