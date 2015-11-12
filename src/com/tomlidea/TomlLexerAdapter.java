package com.tomlidea;

import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

public class TomlLexerAdapter extends FlexAdapter {
    public TomlLexerAdapter() {
        super(new TomlLexer((Reader) null));
    }
}
