package com.tomlidea;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class TomlFileType extends LanguageFileType {
    public static final TomlFileType INSTANCE = new TomlFileType();

    private TomlFileType() {
        super(TomlLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "TOML";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "TOML language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "toml";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return TomlIcons.FILE;
    }
}
