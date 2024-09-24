package com.usooft.idea.plugin.ud.lang.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.parser.GeneratedParserUtilBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;

public class UMParserUtil extends GeneratedParserUtilBase {

    public static boolean isNotWhiteSpace(PsiBuilder builder, int level) {
        if (builder.eof()) return false;
        IElementType nextType = builder.lookAhead(0);
        return nextType != TokenType.WHITE_SPACE;
    }

}