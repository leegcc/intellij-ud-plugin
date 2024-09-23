// This is a generated file. Not intended for manual editing.
package com.usooft.idea.plugin.ud.lang.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.usooft.idea.plugin.ud.lang.psi.UMTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class UMParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return root(b, l + 1);
  }

  /* ********************************************************** */
  // AT attributeName attributeParams?
  public static boolean attribute(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute")) return false;
    if (!nextTokenIs(b, AT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AT);
    r = r && attributeName(b, l + 1);
    r = r && attribute_2(b, l + 1);
    exit_section_(b, m, ATTRIBUTE, r);
    return r;
  }

  // attributeParams?
  private static boolean attribute_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_2")) return false;
    attributeParams(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER (DOT IDENTIFIER)*
  public static boolean attributeName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attributeName")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && attributeName_1(b, l + 1);
    exit_section_(b, m, ATTRIBUTE_NAME, r);
    return r;
  }

  // (DOT IDENTIFIER)*
  private static boolean attributeName_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attributeName_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!attributeName_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "attributeName_1", c)) break;
    }
    return true;
  }

  // DOT IDENTIFIER
  private static boolean attributeName_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attributeName_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LPAREN attributeValue (COMMA attributeValue)* RPAREN
  public static boolean attributeParams(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attributeParams")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ATTRIBUTE_PARAMS, "<attribute params>");
    r = consumeToken(b, LPAREN);
    p = r; // pin = 1
    r = r && report_error_(b, attributeValue(b, l + 1));
    r = p && report_error_(b, attributeParams_2(b, l + 1)) && r;
    r = p && consumeToken(b, RPAREN) && r;
    exit_section_(b, l, m, r, p, UMParser::recovery_rule);
    return r || p;
  }

  // (COMMA attributeValue)*
  private static boolean attributeParams_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attributeParams_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!attributeParams_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "attributeParams_2", c)) break;
    }
    return true;
  }

  // COMMA attributeValue
  private static boolean attributeParams_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attributeParams_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && attributeValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // functionCall | computedExpr | NUMBER | STRING | BOOLEAN | REGEX
  public static boolean attributeValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attributeValue")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ATTRIBUTE_VALUE, "<attribute value>");
    r = functionCall(b, l + 1);
    if (!r) r = computedExpr(b, l + 1);
    if (!r) r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, BOOLEAN);
    if (!r) r = consumeToken(b, REGEX);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER (DOT IDENTIFIER)?
  public static boolean attributeValueReference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attributeValueReference")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && attributeValueReference_1(b, l + 1);
    exit_section_(b, m, ATTRIBUTE_VALUE_REFERENCE, r);
    return r;
  }

  // (DOT IDENTIFIER)?
  private static boolean attributeValueReference_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attributeValueReference_1")) return false;
    attributeValueReference_1_0(b, l + 1);
    return true;
  }

  // DOT IDENTIFIER
  private static boolean attributeValueReference_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attributeValueReference_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // BLOCK_COMMENT | LINE_COMMENT
  public static boolean comment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comment")) return false;
    if (!nextTokenIs(b, "<comment>", BLOCK_COMMENT, LINE_COMMENT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMMENT, "<comment>");
    r = consumeToken(b, BLOCK_COMMENT);
    if (!r) r = consumeToken(b, LINE_COMMENT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // attributeValueReference ((PLUS | MINUS | MULT | DIV) attributeValueReference)?
  public static boolean computedExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "computedExpr")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = attributeValueReference(b, l + 1);
    r = r && computedExpr_1(b, l + 1);
    exit_section_(b, m, COMPUTED_EXPR, r);
    return r;
  }

  // ((PLUS | MINUS | MULT | DIV) attributeValueReference)?
  private static boolean computedExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "computedExpr_1")) return false;
    computedExpr_1_0(b, l + 1);
    return true;
  }

  // (PLUS | MINUS | MULT | DIV) attributeValueReference
  private static boolean computedExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "computedExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = computedExpr_1_0_0(b, l + 1);
    r = r && attributeValueReference(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // PLUS | MINUS | MULT | DIV
  private static boolean computedExpr_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "computedExpr_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, MULT);
    if (!r) r = consumeToken(b, DIV);
    return r;
  }

  /* ********************************************************** */
  // enumDeclaration | fieldDeclaration | relationsBlock | methodsBlock
  public static boolean entityBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entityBody")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ENTITY_BODY, "<entity body>");
    r = enumDeclaration(b, l + 1);
    if (!r) r = fieldDeclaration(b, l + 1);
    if (!r) r = relationsBlock(b, l + 1);
    if (!r) r = methodsBlock(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ENTITY_KEYWORD IDENTIFIER DESC LBRACE (entityBody | comment)* RBRACE
  public static boolean entityDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entityDeclaration")) return false;
    if (!nextTokenIs(b, ENTITY_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ENTITY_DECLARATION, null);
    r = consumeTokens(b, 2, ENTITY_KEYWORD, IDENTIFIER, DESC, LBRACE);
    p = r; // pin = 2
    r = r && report_error_(b, entityDeclaration_4(b, l + 1));
    r = p && consumeToken(b, RBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (entityBody | comment)*
  private static boolean entityDeclaration_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entityDeclaration_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!entityDeclaration_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "entityDeclaration_4", c)) break;
    }
    return true;
  }

  // entityBody | comment
  private static boolean entityDeclaration_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entityDeclaration_4_0")) return false;
    boolean r;
    r = entityBody(b, l + 1);
    if (!r) r = comment(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // ENUM_KEYWORD IDENTIFIER DESC LBRACE (enumValue | comment)* RBRACE
  public static boolean enumDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumDeclaration")) return false;
    if (!nextTokenIs(b, ENUM_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ENUM_DECLARATION, null);
    r = consumeTokens(b, 2, ENUM_KEYWORD, IDENTIFIER, DESC, LBRACE);
    p = r; // pin = 2
    r = r && report_error_(b, enumDeclaration_4(b, l + 1));
    r = p && consumeToken(b, RBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (enumValue | comment)*
  private static boolean enumDeclaration_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumDeclaration_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!enumDeclaration_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "enumDeclaration_4", c)) break;
    }
    return true;
  }

  // enumValue | comment
  private static boolean enumDeclaration_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumDeclaration_4_0")) return false;
    boolean r;
    r = enumValue(b, l + 1);
    if (!r) r = comment(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER DESC
  public static boolean enumValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumValue")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, DESC);
    exit_section_(b, m, ENUM_VALUE, r);
    return r;
  }

  /* ********************************************************** */
  // !(METHODS_KEYWORD | RELATIONS_KEYWORD) IDENTIFIER fieldType DESC attribute*
  public static boolean fieldDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fieldDeclaration")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FIELD_DECLARATION, null);
    r = fieldDeclaration_0(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    p = r; // pin = 2
    r = r && report_error_(b, fieldType(b, l + 1));
    r = p && report_error_(b, consumeToken(b, DESC)) && r;
    r = p && fieldDeclaration_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // !(METHODS_KEYWORD | RELATIONS_KEYWORD)
  private static boolean fieldDeclaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fieldDeclaration_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !fieldDeclaration_0_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // METHODS_KEYWORD | RELATIONS_KEYWORD
  private static boolean fieldDeclaration_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fieldDeclaration_0_0")) return false;
    boolean r;
    r = consumeToken(b, METHODS_KEYWORD);
    if (!r) r = consumeToken(b, RELATIONS_KEYWORD);
    return r;
  }

  // attribute*
  private static boolean fieldDeclaration_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fieldDeclaration_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!attribute(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "fieldDeclaration_4", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // BUILTIN_TYPE | IDENTIFIER
  public static boolean fieldType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fieldType")) return false;
    if (!nextTokenIs(b, "<field type>", BUILTIN_TYPE, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FIELD_TYPE, "<field type>");
    r = consumeToken(b, BUILTIN_TYPE);
    if (!r) r = consumeToken(b, IDENTIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER LPAREN functionParams? RPAREN
  public static boolean functionCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionCall")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, LPAREN);
    r = r && functionCall_2(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, FUNCTION_CALL, r);
    return r;
  }

  // functionParams?
  private static boolean functionCall_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionCall_2")) return false;
    functionParams(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // attributeValue
  public static boolean functionParam(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionParam")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_PARAM, "<function param>");
    r = attributeValue(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // functionParam (COMMA functionParam)*
  public static boolean functionParams(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionParams")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_PARAMS, "<function params>");
    r = functionParam(b, l + 1);
    r = r && functionParams_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (COMMA functionParam)*
  private static boolean functionParams_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionParams_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!functionParams_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "functionParams_1", c)) break;
    }
    return true;
  }

  // COMMA functionParam
  private static boolean functionParams_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionParams_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && functionParam(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // entityDeclaration
  static boolean item(PsiBuilder b, int l) {
    return entityDeclaration(b, l + 1);
  }

  /* ********************************************************** */
  // methodName LPAREN methodParams? RPAREN DESC? attribute*
  public static boolean methodDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "methodDeclaration")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, METHOD_DECLARATION, "<method declaration>");
    r = methodName(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, LPAREN));
    r = p && report_error_(b, methodDeclaration_2(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, RPAREN)) && r;
    r = p && report_error_(b, methodDeclaration_4(b, l + 1)) && r;
    r = p && methodDeclaration_5(b, l + 1) && r;
    exit_section_(b, l, m, r, p, UMParser::method_recover);
    return r || p;
  }

  // methodParams?
  private static boolean methodDeclaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "methodDeclaration_2")) return false;
    methodParams(b, l + 1);
    return true;
  }

  // DESC?
  private static boolean methodDeclaration_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "methodDeclaration_4")) return false;
    consumeToken(b, DESC);
    return true;
  }

  // attribute*
  private static boolean methodDeclaration_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "methodDeclaration_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!attribute(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "methodDeclaration_5", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean methodName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "methodName")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, METHOD_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER (PLUS | MINUS | QUESTION)? (EQUALS methodParamValue)?
  public static boolean methodParam(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "methodParam")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && methodParam_1(b, l + 1);
    r = r && methodParam_2(b, l + 1);
    exit_section_(b, m, METHOD_PARAM, r);
    return r;
  }

  // (PLUS | MINUS | QUESTION)?
  private static boolean methodParam_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "methodParam_1")) return false;
    methodParam_1_0(b, l + 1);
    return true;
  }

  // PLUS | MINUS | QUESTION
  private static boolean methodParam_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "methodParam_1_0")) return false;
    boolean r;
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, QUESTION);
    return r;
  }

  // (EQUALS methodParamValue)?
  private static boolean methodParam_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "methodParam_2")) return false;
    methodParam_2_0(b, l + 1);
    return true;
  }

  // EQUALS methodParamValue
  private static boolean methodParam_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "methodParam_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQUALS);
    r = r && methodParamValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // statusTransaction | NUMBER | STRING | BOOLEAN | REGEX | IDENTIFIER
  public static boolean methodParamValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "methodParamValue")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, METHOD_PARAM_VALUE, "<method param value>");
    r = statusTransaction(b, l + 1);
    if (!r) r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, BOOLEAN);
    if (!r) r = consumeToken(b, REGEX);
    if (!r) r = consumeToken(b, IDENTIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // methodParam (COMMA methodParam)*
  public static boolean methodParams(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "methodParams")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = methodParam(b, l + 1);
    r = r && methodParams_1(b, l + 1);
    exit_section_(b, m, METHOD_PARAMS, r);
    return r;
  }

  // (COMMA methodParam)*
  private static boolean methodParams_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "methodParams_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!methodParams_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "methodParams_1", c)) break;
    }
    return true;
  }

  // COMMA methodParam
  private static boolean methodParams_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "methodParams_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && methodParam(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // !(RBRACE | methodName)
  static boolean method_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !method_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // RBRACE | methodName
  private static boolean method_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_recover_0")) return false;
    boolean r;
    r = consumeToken(b, RBRACE);
    if (!r) r = methodName(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // METHODS_KEYWORD LBRACE (methodDeclaration | comment)* RBRACE
  public static boolean methodsBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "methodsBlock")) return false;
    if (!nextTokenIs(b, METHODS_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, METHODS_BLOCK, null);
    r = consumeTokens(b, 1, METHODS_KEYWORD, LBRACE);
    p = r; // pin = 1
    r = r && report_error_(b, methodsBlock_2(b, l + 1));
    r = p && consumeToken(b, RBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (methodDeclaration | comment)*
  private static boolean methodsBlock_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "methodsBlock_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!methodsBlock_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "methodsBlock_2", c)) break;
    }
    return true;
  }

  // methodDeclaration | comment
  private static boolean methodsBlock_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "methodsBlock_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = methodDeclaration(b, l + 1);
    if (!r) r = comment(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // COMMA | RPAREN
  static boolean recovery_rule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recovery_rule")) return false;
    if (!nextTokenIs(b, "", COMMA, RPAREN)) return false;
    boolean r;
    r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, RPAREN);
    return r;
  }

  /* ********************************************************** */
  // LBRACE relationField* RBRACE
  public static boolean relationBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationBody")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, RELATION_BODY, "<relation body>");
    r = consumeToken(b, LBRACE);
    p = r; // pin = 1
    r = r && report_error_(b, relationBody_1(b, l + 1));
    r = p && consumeToken(b, RBRACE) && r;
    exit_section_(b, l, m, r, p, UMParser::relation_body_recover);
    return r || p;
  }

  // relationField*
  private static boolean relationBody_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationBody_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!relationField(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "relationBody_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // relationName relationTarget attribute* relationBody?
  public static boolean relationDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationDeclaration")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, RELATION_DECLARATION, "<relation declaration>");
    r = relationName(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, relationTarget(b, l + 1));
    r = p && report_error_(b, relationDeclaration_2(b, l + 1)) && r;
    r = p && relationDeclaration_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, UMParser::relation_recover);
    return r || p;
  }

  // attribute*
  private static boolean relationDeclaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationDeclaration_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!attribute(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "relationDeclaration_2", c)) break;
    }
    return true;
  }

  // relationBody?
  private static boolean relationDeclaration_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationDeclaration_3")) return false;
    relationBody(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER attribute*
  public static boolean relationField(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationField")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, RELATION_FIELD, "<relation field>");
    r = consumeToken(b, IDENTIFIER);
    p = r; // pin = 1
    r = r && relationField_1(b, l + 1);
    exit_section_(b, l, m, r, p, UMParser::relation_field_recover);
    return r || p;
  }

  // attribute*
  private static boolean relationField_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationField_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!attribute(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "relationField_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean relationName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationName")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, RELATION_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER (DOT IDENTIFIER)?
  public static boolean relationTarget(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationTarget")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && relationTarget_1(b, l + 1);
    exit_section_(b, m, RELATION_TARGET, r);
    return r;
  }

  // (DOT IDENTIFIER)?
  private static boolean relationTarget_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationTarget_1")) return false;
    relationTarget_1_0(b, l + 1);
    return true;
  }

  // DOT IDENTIFIER
  private static boolean relationTarget_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationTarget_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // !(RBRACE | relationName)
  static boolean relation_body_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relation_body_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !relation_body_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // RBRACE | relationName
  private static boolean relation_body_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relation_body_recover_0")) return false;
    boolean r;
    r = consumeToken(b, RBRACE);
    if (!r) r = relationName(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // !(RBRACE | IDENTIFIER)
  static boolean relation_field_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relation_field_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !relation_field_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // RBRACE | IDENTIFIER
  private static boolean relation_field_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relation_field_recover_0")) return false;
    boolean r;
    r = consumeToken(b, RBRACE);
    if (!r) r = consumeToken(b, IDENTIFIER);
    return r;
  }

  /* ********************************************************** */
  // !(RBRACE | relationName)
  static boolean relation_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relation_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !relation_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // RBRACE | relationName
  private static boolean relation_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relation_recover_0")) return false;
    boolean r;
    r = consumeToken(b, RBRACE);
    if (!r) r = relationName(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // RELATIONS_KEYWORD LBRACE (relationDeclaration | comment)* RBRACE
  public static boolean relationsBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationsBlock")) return false;
    if (!nextTokenIs(b, RELATIONS_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, RELATIONS_KEYWORD, LBRACE);
    r = r && relationsBlock_2(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, RELATIONS_BLOCK, r);
    return r;
  }

  // (relationDeclaration | comment)*
  private static boolean relationsBlock_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationsBlock_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!relationsBlock_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "relationsBlock_2", c)) break;
    }
    return true;
  }

  // relationDeclaration | comment
  private static boolean relationsBlock_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationsBlock_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = relationDeclaration(b, l + 1);
    if (!r) r = comment(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (item | comment)*
  static boolean root(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root")) return false;
    while (true) {
      int c = current_position_(b);
      if (!root_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "root", c)) break;
    }
    return true;
  }

  // item | comment
  private static boolean root_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root_0")) return false;
    boolean r;
    r = item(b, l + 1);
    if (!r) r = comment(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // (BOOLEAN PIPE BOOLEAN) | (IDENTIFIER PIPE IDENTIFIER)
  public static boolean statusTransaction(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statusTransaction")) return false;
    if (!nextTokenIs(b, "<status transaction>", BOOLEAN, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATUS_TRANSACTION, "<status transaction>");
    r = statusTransaction_0(b, l + 1);
    if (!r) r = statusTransaction_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // BOOLEAN PIPE BOOLEAN
  private static boolean statusTransaction_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statusTransaction_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, BOOLEAN, PIPE, BOOLEAN);
    exit_section_(b, m, null, r);
    return r;
  }

  // IDENTIFIER PIPE IDENTIFIER
  private static boolean statusTransaction_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statusTransaction_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, PIPE, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

}
