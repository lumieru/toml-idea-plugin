package com.tomlidea.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.tomlidea.psi.TomlNamedElement;
import org.jetbrains.annotations.NotNull;

public abstract class TomlNamedElementImpl extends ASTWrapperPsiElement implements TomlNamedElement {
    public TomlNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }
}
