// This is a generated file. Not intended for manual editing.
package com.usooft.idea.plugin.ud.lang.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.usooft.idea.plugin.ud.lang.psi.impl.*;

public interface UPTypes {

  IElementType COMMENT = new UPElementType("COMMENT");
  IElementType MODULE_DECLARATION = new UPElementType("MODULE_DECLARATION");
  IElementType PACKAGE_DECLARATION = new UPElementType("PACKAGE_DECLARATION");

  IElementType BLOCK_COMMENT = new UPTokenType("BLOCK_COMMENT");
  IElementType DESC = new UPTokenType("DESC");
  IElementType IDENTIFIER = new UPTokenType("IDENTIFIER");
  IElementType MODULE_KEYWORD = new UPTokenType("MODULE_KEYWORD");
  IElementType PACKAGE_KEYWORD = new UPTokenType("PACKAGE_KEYWORD");
  IElementType PACKAGE_NAME = new UPTokenType("PACKAGE_NAME");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == COMMENT) {
        return new UPCommentImpl(node);
      }
      else if (type == MODULE_DECLARATION) {
        return new UPModuleDeclarationImpl(node);
      }
      else if (type == PACKAGE_DECLARATION) {
        return new UPPackageDeclarationImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
