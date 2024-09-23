package com.usooft.idea.plugin.ud.lang;

import com.intellij.lexer.FlexAdapter;

public class UPLexerAdapter extends FlexAdapter {
    public UPLexerAdapter() {
        super(new UPLexer(null));
    }
}
