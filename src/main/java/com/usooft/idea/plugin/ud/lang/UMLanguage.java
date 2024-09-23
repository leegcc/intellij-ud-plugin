package com.usooft.idea.plugin.ud.lang;

import com.intellij.lang.Language;

public class UMLanguage extends Language {

    public static final UMLanguage INSTANCE = new UMLanguage();

    private UMLanguage() {
        super("UM");
    }

}
