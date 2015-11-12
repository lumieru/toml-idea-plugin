package com.tomlidea;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.tomlidea.psi.TomlTypes;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class TomlSyntaxHighlighter extends SyntaxHighlighterBase {
    public static final TextAttributesKey DOT = createTextAttributesKey("TOML_DOT", DefaultLanguageHighlighterColors.DOT);
    public static final TextAttributesKey COMMA = createTextAttributesKey("TOML_COMMA", DefaultLanguageHighlighterColors.COMMA);
    public static final TextAttributesKey EQ = createTextAttributesKey("TOML_EQ", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey BRACKET = createTextAttributesKey("TOML_BRACKET", DefaultLanguageHighlighterColors.BRACKETS);
    public static final TextAttributesKey BRACE = createTextAttributesKey("TOML_BRACE", DefaultLanguageHighlighterColors.BRACES);
    public static final TextAttributesKey KEY = createTextAttributesKey("TOML_KEY", DefaultLanguageHighlighterColors.INSTANCE_FIELD);
    public static final TextAttributesKey STRING = createTextAttributesKey("TOML_STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey BOOLEAN = createTextAttributesKey("TOML_BOOLEAN", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey DATE = createTextAttributesKey("TOML_DATE", DefaultLanguageHighlighterColors.CONSTANT);
    public static final TextAttributesKey NUMBER = createTextAttributesKey("TOML_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey COMMENT = createTextAttributesKey("TOML_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BAD_CHARACTER = createTextAttributesKey("TOML_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);
    public static final TextAttributesKey TABLE_HEADER = createTextAttributesKey("TOML_TABLE_HEADER", DefaultLanguageHighlighterColors.CLASS_NAME);
    public static final TextAttributesKey TABLE_ARRAY_HEADER = createTextAttributesKey("TOML_TABLE_ARRAY_HEADER", DefaultLanguageHighlighterColors.CLASS_NAME);

    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] DOT_KEYS = new TextAttributesKey[]{DOT};
    private static final TextAttributesKey[] COMMA_KEYS = new TextAttributesKey[]{COMMA};
    private static final TextAttributesKey[] EQ_KEYS = new TextAttributesKey[]{EQ};
    private static final TextAttributesKey[] BRACKET_KEYS = new TextAttributesKey[]{BRACKET};
    private static final TextAttributesKey[] BRACE_KEYS = new TextAttributesKey[]{BRACE};
    private static final TextAttributesKey[] KEY_KEYS = new TextAttributesKey[]{KEY};
    private static final TextAttributesKey[] STRING_KEYS = new TextAttributesKey[]{STRING};
    private static final TextAttributesKey[] BOOLEAN_KEYS = new TextAttributesKey[]{BOOLEAN};
    private static final TextAttributesKey[] DATE_KEYS = new TextAttributesKey[]{DATE};
    private static final TextAttributesKey[] NUMBER_KEYS = new TextAttributesKey[]{NUMBER};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new TomlLexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(TomlTypes.EQ)) {
            return EQ_KEYS;
        } else if (tokenType.equals(TomlTypes.DOT)) {
            return DOT_KEYS;
        } else if (tokenType.equals(TomlTypes.COMMA)) {
            return COMMA_KEYS;
        } else if (tokenType.equals(TomlTypes.LBRACKET) ||
                   tokenType.equals(TomlTypes.RBRACKET)) {
            return BRACKET_KEYS;
        } else if (tokenType.equals(TomlTypes.LBRACE) ||
                   tokenType.equals(TomlTypes.RBRACE)) {
            return BRACE_KEYS;
        } else if (tokenType.equals(TomlTypes.DQMSTRING) ||
                tokenType.equals(TomlTypes.DQSSTRING) ||
                tokenType.equals(TomlTypes.SQMSTRING) ||
                tokenType.equals(TomlTypes.SQSSTRING) ||
                tokenType.equals(TomlTypes.SQMCHAR) ||
                tokenType.equals(TomlTypes.SQMSTRQUOTER)) {
            return STRING_KEYS;
        } else if (tokenType.equals(TomlTypes.BOOLEAN)) {
            return BOOLEAN_KEYS;
        } else if (tokenType.equals(TomlTypes.DATE)) {
            return DATE_KEYS;
        } else if (tokenType.equals(TomlTypes.NUMBER)) {
            return NUMBER_KEYS;
        } else if (tokenType.equals(TomlTypes.BAREKEY)) {
            return KEY_KEYS;
        } else if (tokenType.equals(TomlTypes.COMMENT)) {
            return COMMENT_KEYS;
        } else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        } else {
            return EMPTY_KEYS;
        }
    }
}
