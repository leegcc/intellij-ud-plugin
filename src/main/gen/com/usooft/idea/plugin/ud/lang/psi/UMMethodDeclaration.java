// This is a generated file. Not intended for manual editing.
package com.usooft.idea.plugin.ud.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface UMMethodDeclaration extends PsiElement {

  @NotNull
  List<UMAttribute> getAttributeList();

  @NotNull
  UMMethodName getMethodName();

  @Nullable
  UMMethodParams getMethodParams();

}
