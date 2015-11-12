package com.tomlidea.psi;

import com.intellij.psi.tree.IElementType;
import com.tomlidea.TomlLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class TomlTokenType extends IElementType {
    public TomlTokenType(@NotNull @NonNls String debugName) {
        super(debugName, TomlLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "TomlTokenType." + super.toString();
    }
}
