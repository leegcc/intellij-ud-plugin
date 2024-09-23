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
import com.usooft.idea.plugin.ud.lang.parser.UMParser;
import com.usooft.idea.plugin.ud.lang.psi.UMTypes;
import org.jetbrains.annotations.NotNull;

public class UMParserDefinition implements ParserDefinition {

    public static final IFileElementType FILE = new IFileElementType(UMLanguage.INSTANCE);

    @Override
    public @NotNull Lexer createLexer(Project project) {
        return new UMLexerAdapter();
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {
        return UMTokenSets.COMMENTS;
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return UMTokenSets.STRINGS;
    }

    @NotNull
    @Override
    public PsiParser createParser(final Project project) {
        return new UMParser();
    }

    @NotNull
    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    @NotNull
    @Override
    public PsiFile createFile(@NotNull FileViewProvider viewProvider) {
        return new UMFile(viewProvider);
    }

    @NotNull
    @Override
    public PsiElement createElement(ASTNode node) {
        return UMTypes.Factory.createElement(node);
    }

}