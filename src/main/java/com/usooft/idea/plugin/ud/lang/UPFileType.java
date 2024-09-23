package com.usooft.idea.plugin.ud.lang;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class UPFileType extends LanguageFileType {

    public static final UPFileType INSTANCE = new UPFileType();

    private UPFileType() {
        super(UPLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "UD Project File";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "UD Project file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "up";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return UDIcons.UP_FILE;
    }
}