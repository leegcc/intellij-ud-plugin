package com.usooft.idea.plugin.ud.lang;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import com.usooft.idea.plugin.ud.lang.parser.UPParser;
import com.usooft.idea.plugin.ud.lang.psi.UPTypes;
import org.jetbrains.annotations.NotNull;

/**
 * 不知道什么原因，使用类名 `UPParserDefinition` 时，无法编译成 .class
 */
public class UPParserDefinitionImpl implements ParserDefinition {

    public static final IFileElementType FILE = new IFileElementType(UPLanguage.INSTANCE);

    @Override
    public @NotNull Lexer createLexer(Project project) {
        return new UPLexerAdapter();
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {
        return UPTokenSets.COMMENTS;
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    @NotNull
    @Override
    public PsiParser createParser(final Project project) {
        return new UPParser();
    }

    @NotNull
    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    @NotNull
    @Override
    public PsiFile createFile(@NotNull FileViewProvider viewProvider) {
        return new UPFile(viewProvider);
    }

    @NotNull
    @Override
    public PsiElement createElement(ASTNode node) {
        return UPTypes.Factory.createElement(node);
    }

}