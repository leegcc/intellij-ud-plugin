// This is a generated file. Not intended for manual editing.
package com.usooft.idea.plugin.ud.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface UMRelationDeclaration extends PsiElement {

  @NotNull
  List<UMAttribute> getAttributeList();

  @Nullable
  UMRelationBody getRelationBody();

  @NotNull
  UMRelationName getRelationName();

  @Nullable
  UMRelationTarget getRelationTarget();

}
