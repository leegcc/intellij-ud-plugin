package com.usooft.idea.plugin.ud.lang.highlight;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import com.usooft.idea.plugin.ud.lang.UPLexerAdapter;
import com.usooft.idea.plugin.ud.lang.psi.UPTypes;
import org.jetbrains.annotations.NotNull;

public class UPSyntaxHighlighter extends SyntaxHighlighterBase {

    public static final TextAttributesKey KEYWORD = TextAttributesKey.createTextAttributesKey("KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey COMMENT = TextAttributesKey.createTextAttributesKey("COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey IDENTIFIER = TextAttributesKey.createTextAttributesKey("IDENTIFIER", DefaultLanguageHighlighterColors.INSTANCE_FIELD);

    @Override
    public @NotNull Lexer getHighlightingLexer() {
        return new UPLexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(UPTypes.BLOCK_COMMENT) || tokenType.equals(UPTypes.DESC)) {
            return new TextAttributesKey[]{COMMENT};
        } else if (tokenType.equals(UPTypes.MODULE_KEYWORD) || tokenType.equals(UPTypes.PACKAGE_KEYWORD)) {
            return new TextAttributesKey[]{KEYWORD};
        }
        return TextAttributesKey.EMPTY_ARRAY;
    }

}