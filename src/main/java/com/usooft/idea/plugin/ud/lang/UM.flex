package com.usooft.idea.plugin.ud.lang;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.usooft.idea.plugin.ud.lang.psi.UMTypes;
import com.intellij.psi.TokenType;

%%

%class UMLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

WHITE_SPACE=[\ \n\t\f]
IDENTIFIER=[a-zA-Z_][a-zA-Z0-9_]*
NUMBER=[0-9]+(\.[0-9]*)?
STRING=\"([^\\\"\r\n]|\\[^\r\n])*\"
BOOLEAN="true"|"false"
DESC="<"([^\n>])*">"
LINE_COMMENT="//".*
BLOCK_COMMENT="/"\*([^*]|\*+[^*/])*\*+"/"
REGEX="/"([^\n/])*"/"
ATTRIBUTE_PATTERN="@"[a-zA-Z.]+
%%

<YYINITIAL> {
  "@@relations"         { return UMTypes.RELATIONS_KEYWORD; }
  "@@methods"           { return UMTypes.METHODS_KEYWORD; }
  "entity"              { return UMTypes.ENTITY_KEYWORD; }
  "enum"                { return UMTypes.ENUM_KEYWORD; }
  "{"                   { return UMTypes.LBRACE; }
  "}"                   { return UMTypes.RBRACE; }
  "("                   { return UMTypes.LPAREN; }
  ")"                   { return UMTypes.RPAREN; }
  "|"                   { return UMTypes.PIPE; }
  ","                   { return UMTypes.COMMA; }
  "="                   { return UMTypes.EQUALS; }
  "."                   { return UMTypes.DOT; }
  "+"                   { return UMTypes.PLUS; }
  "-"                   { return UMTypes.MINUS; }
  "*"                   { return UMTypes.MULT; }
  "/"                   { return UMTypes.DIV; }
  ">"                   { return UMTypes.GT; }
  "<"                   { return UMTypes.LT; }
  ">="                  { return UMTypes.GTE; }
  "<="                  { return UMTypes.LTE; }
  "=="                  { return UMTypes.DOUBLE_EQUALS; }
  "?"                   { return UMTypes.QUESTION; }

  "Int" | "String" | "Boolean" | "DateTime" | "Decimal" { return UMTypes.BUILTIN_TYPE; }

  {ATTRIBUTE_PATTERN}   { return UMTypes.ATTRIBUTE_PATTERN; }
  {REGEX}               { return UMTypes.REGEX; }
  {BOOLEAN}             { return UMTypes.BOOLEAN; }
  {NUMBER}              { return UMTypes.NUMBER; }
  {STRING}              { return UMTypes.STRING; }
  {DESC}                { return UMTypes.DESC; }
  {LINE_COMMENT}        { return UMTypes.LINE_COMMENT; }
  {BLOCK_COMMENT}       { return UMTypes.BLOCK_COMMENT; }
  {IDENTIFIER}          { return UMTypes.IDENTIFIER; }

  {WHITE_SPACE}         { return TokenType.WHITE_SPACE; }
}

[^] { return TokenType.BAD_CHARACTER; }
