package com.usooft.idea.plugin.ud.lang.typed;

import com.intellij.codeInsight.editorActions.TypedHandlerDelegate;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFile;
import com.usooft.idea.plugin.ud.lang.UMFileType;
import com.usooft.idea.plugin.ud.lang.UPFileType;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class UPTypedHandler extends TypedHandlerDelegate {

    private static final Map<Character, Character> MATCHING_CHARS = Map.of(
            '(', ')',
            '[', ']',
            '{', '}',
            '"', '"',
            '<', '>'
    );

    @Override
    public @NotNull Result charTyped(char c, @NotNull Project project, @NotNull Editor editor, @NotNull PsiFile file) {
        if (isValidFileType(file)) {
            Character closingChar = getMatchingClosingChar(c);
            if (closingChar != null) {
                return insertClosingCharAndRepositionCaret(editor, closingChar.toString());
            }
        }
        return Result.CONTINUE;
    }

    private Character getMatchingClosingChar(char openChar) {
        return MATCHING_CHARS.get(openChar);
    }

    private Result insertClosingCharAndRepositionCaret(Editor editor, String toInsert) {
        editor.getDocument().insertString(editor.getCaretModel().getOffset(), toInsert);
        editor.getCaretModel().moveToOffset(editor.getCaretModel().getOffset());
        return Result.STOP;
    }

    private boolean isValidFileType(PsiFile file) {
        return file.getFileType() instanceof UPFileType || file.getFileType() instanceof UMFileType;
    }

}