package com.tomlidea;

import com.intellij.lang.Language;

public class TomlLanguage extends Language {
    public static final TomlLanguage INSTANCE = new TomlLanguage();

    private TomlLanguage() {
        super("toml");
    }
}
