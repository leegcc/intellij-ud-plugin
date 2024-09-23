package com.usooft.idea.plugin.ud.lang;

import com.intellij.psi.tree.TokenSet;
import com.usooft.idea.plugin.ud.lang.psi.UPTypes;

public interface UPTokenSets {

    TokenSet IDENTIFIERS = TokenSet.create(UPTypes.IDENTIFIER);

    TokenSet COMMENTS = TokenSet.create(UPTypes.COMMENT);

}