package com.usooft.idea.plugin.ud.lang.psi;

import com.intellij.psi.tree.IElementType;
import com.usooft.idea.plugin.ud.lang.UPLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class UPElementType extends IElementType {

    public UPElementType(@NonNls @NotNull String debugName) {
        super(debugName, UPLanguage.INSTANCE);
    }

}
