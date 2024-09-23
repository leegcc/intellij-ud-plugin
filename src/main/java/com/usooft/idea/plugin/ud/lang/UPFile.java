package com.usooft.idea.plugin.ud.lang;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

public class UPFile extends PsiFileBase {

    public UPFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, UPLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return UPFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "UP File";
    }

}