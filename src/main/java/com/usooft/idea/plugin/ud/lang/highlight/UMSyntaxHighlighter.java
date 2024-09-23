package com.usooft.idea.plugin.ud.lang.highlight;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import com.usooft.idea.plugin.ud.lang.UMLexerAdapter;
import com.usooft.idea.plugin.ud.lang.psi.UMTypes;
import org.jetbrains.annotations.NotNull;

public class UMSyntaxHighlighter extends SyntaxHighlighterBase {

    public static final TextAttributesKey KEYWORD = TextAttributesKey.createTextAttributesKey("UM_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey COMMENT = TextAttributesKey.createTextAttributesKey("UM_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey IDENTIFIER = TextAttributesKey.createTextAttributesKey("UM_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey BOOLEAN = TextAttributesKey.createTextAttributesKey("UM_BOOLEAN", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey STRING = TextAttributesKey.createTextAttributesKey("UM_STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey NUMBER = TextAttributesKey.createTextAttributesKey("UM_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey BRACES = TextAttributesKey.createTextAttributesKey("UM_BRACES", DefaultLanguageHighlighterColors.BRACES);
    public static final TextAttributesKey PARENTHESES = TextAttributesKey.createTextAttributesKey("UM_PARENTHESES", DefaultLanguageHighlighterColors.PARENTHESES);
    public static final TextAttributesKey COMMA = TextAttributesKey.createTextAttributesKey("UM_COMMA", DefaultLanguageHighlighterColors.COMMA);
    public static final TextAttributesKey FIELD_ATTRIBUTE_IDENTIFIER = TextAttributesKey.createTextAttributesKey("UM_FIELD_ATTRIBUTES", DefaultLanguageHighlighterColors.METADATA);
    public static final TextAttributesKey FIELD_TYPE = TextAttributesKey.createTextAttributesKey("UM_FIELD_TYPE", DefaultLanguageHighlighterColors.CLASS_NAME);
    public static final TextAttributesKey FIELD_NAME = TextAttributesKey.createTextAttributesKey("UM_FIELD_NAME", DefaultLanguageHighlighterColors.INSTANCE_FIELD);
    public static final TextAttributesKey METHOD_NAME = TextAttributesKey.createTextAttributesKey("UM_METHOD_NAME", DefaultLanguageHighlighterColors.FUNCTION_DECLARATION);
    public static final TextAttributesKey METHOD_SYMBOL = TextAttributesKey.createTextAttributesKey("UM_METHOD_SYMBOL", DefaultLanguageHighlighterColors.METADATA);

    @Override
    public @NotNull Lexer getHighlightingLexer() {
        return new UMLexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(UMTypes.LINE_COMMENT) || tokenType.equals(UMTypes.BLOCK_COMMENT)
            || tokenType.equals(UMTypes.DESC)) {
            return new TextAttributesKey[]{COMMENT};
        } else if (tokenType.equals(UMTypes.ENTITY_KEYWORD) || tokenType.equals(UMTypes.ENUM_KEYWORD)) {
            return new TextAttributesKey[]{KEYWORD};
        } else if (tokenType.equals(UMTypes.IDENTIFIER)) {
            return new TextAttributesKey[]{IDENTIFIER};
        } else if (tokenType.equals(UMTypes.STRING) || tokenType.equals(UMTypes.REGEX)) {
            return new TextAttributesKey[]{STRING};
        } else if (tokenType.equals(UMTypes.NUMBER)) {
            return new TextAttributesKey[]{NUMBER};
        } else if (tokenType.equals(UMTypes.LBRACE) || tokenType.equals(UMTypes.RBRACE)) {
            return new TextAttributesKey[]{BRACES};
        } else if (tokenType.equals(UMTypes.LPAREN) || tokenType.equals(UMTypes.RPAREN)) {
            return new TextAttributesKey[]{PARENTHESES};
        } else if (tokenType.equals(UMTypes.COMMA)) {
            return new TextAttributesKey[]{COMMA};
        } else if (tokenType.equals(UMTypes.FIELD_TYPE)) {
            return new TextAttributesKey[]{FIELD_TYPE};
        } else if (tokenType.equals(UMTypes.BOOLEAN)) {
            return new TextAttributesKey[]{BOOLEAN};
        } else if (tokenType.equals(UMTypes.PIPE)) {
            return new TextAttributesKey[]{METHOD_SYMBOL};
        }
        return TextAttributesKey.EMPTY_ARRAY;
    }
}