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

public class UMAttributeImpl extends ASTWrapperPsiElement implements UMAttribute {

  public UMAttributeImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull UMVisitor visitor) {
    visitor.visitAttribute(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof UMVisitor) accept((UMVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public UMAttributeParams getAttributeParams() {
    return findChildByClass(UMAttributeParams.class);
  }

}
