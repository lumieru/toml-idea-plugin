package com.tomlidea.psi;

import com.intellij.psi.tree.IElementType;
import com.tomlidea.TomlLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class TomlElementType extends IElementType {
    public TomlElementType(@NotNull @NonNls String debugName) {
        super(debugName, TomlLanguage.INSTANCE);
    }
}
