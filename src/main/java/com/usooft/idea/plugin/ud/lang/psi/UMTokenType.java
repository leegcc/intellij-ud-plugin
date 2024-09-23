package com.usooft.idea.plugin.ud.lang.psi;

import com.intellij.psi.tree.IElementType;
import com.usooft.idea.plugin.ud.lang.UMLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class UMTokenType extends IElementType {

    public UMTokenType(@NonNls @NotNull String debugName) {
        super(debugName, UMLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "UMTokenType." + super.toString();
    }

}
