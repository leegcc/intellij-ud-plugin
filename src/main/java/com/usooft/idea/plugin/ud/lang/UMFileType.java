package com.usooft.idea.plugin.ud.lang;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class UMFileType extends LanguageFileType {

    public static final UMFileType INSTANCE = new UMFileType();

    private UMFileType() {
        super(UMLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "UD Module File";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "UD Module file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "um";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return UDIcons.UM_FILE;
    }
}