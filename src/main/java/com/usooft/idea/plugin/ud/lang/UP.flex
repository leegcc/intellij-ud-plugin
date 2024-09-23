package com.usooft.idea.plugin.ud.lang;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.usooft.idea.plugin.ud.lang.psi.UPTypes;

%%

%class UPLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

CRLF=\R
WHITE_SPACE=[\ \n\t\f]
BLOCK_COMMENT="/*"([^*]|\*+[^*/])*\*+"/"
IDENTIFIER=[a-zA-Z_][a-zA-Z0-9_]*
PACKAGE_NAME={IDENTIFIER}(\.{IDENTIFIER})*
DESC="<"([^\n>])*">"

%state PACKAGE_STATE
%state MODULE_STATE

%%

<YYINITIAL> {
  "package"            { yybegin(PACKAGE_STATE); return UPTypes.PACKAGE_KEYWORD; }
  "module"             { yybegin(MODULE_STATE); return UPTypes.MODULE_KEYWORD; }
}

<PACKAGE_STATE> {
  {PACKAGE_NAME}       { return UPTypes.PACKAGE_NAME; }
}

<MODULE_STATE> {
  {DESC}               { return UPTypes.DESC; }
}

{CRLF}                 { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
{BLOCK_COMMENT}        { return UPTypes.BLOCK_COMMENT; }
{IDENTIFIER}           { return UPTypes.IDENTIFIER; }
{WHITE_SPACE}          { return TokenType.WHITE_SPACE; }
[^]                    { return TokenType.BAD_CHARACTER; }