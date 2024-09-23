package com.usooft.idea.plugin.ud.lang;

import com.intellij.lexer.FlexAdapter;

public class UMLexerAdapter extends FlexAdapter {
    public UMLexerAdapter() {
        super(new UMLexer(null));
    }
}
