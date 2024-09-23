package com.usooft.idea.plugin.ud.lang.psi;

import com.intellij.psi.tree.IElementType;
import com.usooft.idea.plugin.ud.lang.UMLanguage;
import com.usooft.idea.plugin.ud.lang.UPLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class UMElementType extends IElementType {

    public UMElementType(@NonNls @NotNull String debugName) {
        super(debugName, UMLanguage.INSTANCE);
    }

}
