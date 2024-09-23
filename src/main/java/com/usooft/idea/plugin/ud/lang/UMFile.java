package com.usooft.idea.plugin.ud.lang;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

public class UMFile extends PsiFileBase {

    public UMFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, UMLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return UMFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "UM File";
    }

}