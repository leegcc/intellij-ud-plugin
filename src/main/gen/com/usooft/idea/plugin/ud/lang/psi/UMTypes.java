// This is a generated file. Not intended for manual editing.
package com.usooft.idea.plugin.ud.lang.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.usooft.idea.plugin.ud.lang.psi.impl.*;

public interface UMTypes {

  IElementType ATTRIBUTE = new UMElementType("ATTRIBUTE");
  IElementType ATTRIBUTE_PARAMS = new UMElementType("ATTRIBUTE_PARAMS");
  IElementType ATTRIBUTE_VALUE = new UMElementType("ATTRIBUTE_VALUE");
  IElementType ATTRIBUTE_VALUE_REFERENCE = new UMElementType("ATTRIBUTE_VALUE_REFERENCE");
  IElementType COMMENT = new UMElementType("COMMENT");
  IElementType COMPUTED_EXPR = new UMElementType("COMPUTED_EXPR");
  IElementType ENTITY_BODY = new UMElementType("ENTITY_BODY");
  IElementType ENTITY_DECLARATION = new UMElementType("ENTITY_DECLARATION");
  IElementType ENUM_DECLARATION = new UMElementType("ENUM_DECLARATION");
  IElementType ENUM_VALUE = new UMElementType("ENUM_VALUE");
  IElementType FIELD_DECLARATION = new UMElementType("FIELD_DECLARATION");
  IElementType FIELD_TYPE = new UMElementType("FIELD_TYPE");
  IElementType FUNCTION_CALL = new UMElementType("FUNCTION_CALL");
  IElementType FUNCTION_PARAM = new UMElementType("FUNCTION_PARAM");
  IElementType FUNCTION_PARAMS = new UMElementType("FUNCTION_PARAMS");
  IElementType METHODS_BLOCK = new UMElementType("METHODS_BLOCK");
  IElementType METHOD_DECLARATION = new UMElementType("METHOD_DECLARATION");
  IElementType METHOD_NAME = new UMElementType("METHOD_NAME");
  IElementType METHOD_PARAM = new UMElementType("METHOD_PARAM");
  IElementType METHOD_PARAMS = new UMElementType("METHOD_PARAMS");
  IElementType METHOD_PARAM_VALUE = new UMElementType("METHOD_PARAM_VALUE");
  IElementType RELATIONS_BLOCK = new UMElementType("RELATIONS_BLOCK");
  IElementType RELATION_BODY = new UMElementType("RELATION_BODY");
  IElementType RELATION_DECLARATION = new UMElementType("RELATION_DECLARATION");
  IElementType RELATION_FIELD = new UMElementType("RELATION_FIELD");
  IElementType RELATION_NAME = new UMElementType("RELATION_NAME");
  IElementType RELATION_TARGET = new UMElementType("RELATION_TARGET");
  IElementType STATUS_TRANSACTION = new UMElementType("STATUS_TRANSACTION");

  IElementType ATTRIBUTE_PATTERN = new UMTokenType("ATTRIBUTE_PATTERN");
  IElementType BLOCK_COMMENT = new UMTokenType("BLOCK_COMMENT");
  IElementType BOOLEAN = new UMTokenType("BOOLEAN");
  IElementType BUILTIN_TYPE = new UMTokenType("BUILTIN_TYPE");
  IElementType COMMA = new UMTokenType("COMMA");
  IElementType DESC = new UMTokenType("DESC");
  IElementType DIV = new UMTokenType("DIV");
  IElementType DOT = new UMTokenType("DOT");
  IElementType DOUBLE_EQUALS = new UMTokenType("DOUBLE_EQUALS");
  IElementType ENTITY_KEYWORD = new UMTokenType("ENTITY_KEYWORD");
  IElementType ENUM_KEYWORD = new UMTokenType("ENUM_KEYWORD");
  IElementType EQUALS = new UMTokenType("EQUALS");
  IElementType GT = new UMTokenType("GT");
  IElementType GTE = new UMTokenType("GTE");
  IElementType IDENTIFIER = new UMTokenType("IDENTIFIER");
  IElementType LBRACE = new UMTokenType("LBRACE");
  IElementType LINE_COMMENT = new UMTokenType("LINE_COMMENT");
  IElementType LPAREN = new UMTokenType("LPAREN");
  IElementType LT = new UMTokenType("LT");
  IElementType LTE = new UMTokenType("LTE");
  IElementType METHODS_KEYWORD = new UMTokenType("METHODS_KEYWORD");
  IElementType MINUS = new UMTokenType("MINUS");
  IElementType MULT = new UMTokenType("MULT");
  IElementType NUMBER = new UMTokenType("NUMBER");
  IElementType PIPE = new UMTokenType("PIPE");
  IElementType PLUS = new UMTokenType("PLUS");
  IElementType QUESTION = new UMTokenType("QUESTION");
  IElementType RBRACE = new UMTokenType("RBRACE");
  IElementType REGEX = new UMTokenType("REGEX");
  IElementType RELATIONS_KEYWORD = new UMTokenType("RELATIONS_KEYWORD");
  IElementType RPAREN = new UMTokenType("RPAREN");
  IElementType STRING = new UMTokenType("STRING");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ATTRIBUTE) {
        return new UMAttributeImpl(node);
      }
      else if (type == ATTRIBUTE_PARAMS) {
        return new UMAttributeParamsImpl(node);
      }
      else if (type == ATTRIBUTE_VALUE) {
        return new UMAttributeValueImpl(node);
      }
      else if (type == ATTRIBUTE_VALUE_REFERENCE) {
        return new UMAttributeValueReferenceImpl(node);
      }
      else if (type == COMMENT) {
        return new UMCommentImpl(node);
      }
      else if (type == COMPUTED_EXPR) {
        return new UMComputedExprImpl(node);
      }
      else if (type == ENTITY_BODY) {
        return new UMEntityBodyImpl(node);
      }
      else if (type == ENTITY_DECLARATION) {
        return new UMEntityDeclarationImpl(node);
      }
      else if (type == ENUM_DECLARATION) {
        return new UMEnumDeclarationImpl(node);
      }
      else if (type == ENUM_VALUE) {
        return new UMEnumValueImpl(node);
      }
      else if (type == FIELD_DECLARATION) {
        return new UMFieldDeclarationImpl(node);
      }
      else if (type == FIELD_TYPE) {
        return new UMFieldTypeImpl(node);
      }
      else if (type == FUNCTION_CALL) {
        return new UMFunctionCallImpl(node);
      }
      else if (type == FUNCTION_PARAM) {
        return new UMFunctionParamImpl(node);
      }
      else if (type == FUNCTION_PARAMS) {
        return new UMFunctionParamsImpl(node);
      }
      else if (type == METHODS_BLOCK) {
        return new UMMethodsBlockImpl(node);
      }
      else if (type == METHOD_DECLARATION) {
        return new UMMethodDeclarationImpl(node);
      }
      else if (type == METHOD_NAME) {
        return new UMMethodNameImpl(node);
      }
      else if (type == METHOD_PARAM) {
        return new UMMethodParamImpl(node);
      }
      else if (type == METHOD_PARAMS) {
        return new UMMethodParamsImpl(node);
      }
      else if (type == METHOD_PARAM_VALUE) {
        return new UMMethodParamValueImpl(node);
      }
      else if (type == RELATIONS_BLOCK) {
        return new UMRelationsBlockImpl(node);
      }
      else if (type == RELATION_BODY) {
        return new UMRelationBodyImpl(node);
      }
      else if (type == RELATION_DECLARATION) {
        return new UMRelationDeclarationImpl(node);
      }
      else if (type == RELATION_FIELD) {
        return new UMRelationFieldImpl(node);
      }
      else if (type == RELATION_NAME) {
        return new UMRelationNameImpl(node);
      }
      else if (type == RELATION_TARGET) {
        return new UMRelationTargetImpl(node);
      }
      else if (type == STATUS_TRANSACTION) {
        return new UMStatusTransactionImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
