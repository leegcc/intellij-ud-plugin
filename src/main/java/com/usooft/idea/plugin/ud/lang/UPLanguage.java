package com.usooft.idea.plugin.ud.lang;

import com.intellij.lang.Language;
import org.jetbrains.annotations.NotNull;

public class UPLanguage extends Language {

    public static final UPLanguage INSTANCE = new UPLanguage();

    private UPLanguage() {
        super("UP");
    }

    @Override
    public @NotNull String getDisplayName() {
        return "UP";
    }

}
