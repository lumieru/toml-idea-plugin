package com.tomlidea;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.psi.PsiElement;
import com.tomlidea.psi.TomlKey;
import com.tomlidea.psi.TomlKeyValue;
import com.tomlidea.psi.TomlTableArrayHeader;
import com.tomlidea.psi.TomlTableHeader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TomlAnnotator implements Annotator {
    @Override
    public void annotate(@NotNull final PsiElement o, @NotNull AnnotationHolder holder) {
        if (!o.isValid()) return;
        if (o instanceof TomlTableHeader) {
            setHighlighting(((TomlTableHeader)o).getPath(), holder, TomlSyntaxHighlighter.TABLE_HEADER, "table header");
        } else if (o instanceof TomlTableArrayHeader) {
            setHighlighting(((TomlTableArrayHeader)o).getPath(), holder, TomlSyntaxHighlighter.TABLE_ARRAY_HEADER, "table array header");
        } else if (o instanceof TomlKey) {
            TomlKey key = (TomlKey)o;
            //If the key is not a bare key, then it needs to be highlighted with KEY color
            if(key.getBarekey() == null && key.getParent() instanceof TomlKeyValue) {
                setHighlighting(o, holder, TomlSyntaxHighlighter.KEY, "key");
            }
        }
    }

    private static void setHighlighting(@NotNull PsiElement element,
                                        @NotNull AnnotationHolder holder,
                                        @NotNull TextAttributesKey key,
                                        @Nullable String description) {
        holder.createInfoAnnotation(element, null).setEnforcedTextAttributes(TextAttributes.ERASE_MARKER);
        holder.createInfoAnnotation(element, ApplicationManager.getApplication().isUnitTestMode() ? description : null).setTextAttributes(key);
    }
}
