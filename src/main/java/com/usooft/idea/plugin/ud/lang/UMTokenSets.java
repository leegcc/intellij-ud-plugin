package com.usooft.idea.plugin.ud.lang;

import com.intellij.psi.tree.TokenSet;
import com.usooft.idea.plugin.ud.lang.psi.UMTypes;
import com.usooft.idea.plugin.ud.lang.psi.UPTypes;

public interface UMTokenSets {

    TokenSet COMMENTS = TokenSet.create(UMTypes.COMMENT);

    TokenSet STRINGS = TokenSet.create(UMTypes.STRING, UMTypes.REGEX);

}