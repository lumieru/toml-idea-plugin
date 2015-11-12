package com.tomlidea.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.tomlidea.TomlFileType;
import com.tomlidea.TomlLanguage;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class TomlFile extends PsiFileBase {
    public TomlFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, TomlLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return TomlFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "TOML File";
    }

    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }
}
