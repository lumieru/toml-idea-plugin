package com.tomlidea;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import com.intellij.util.containers.ContainerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public class TomlColorSettingsPage implements ColorSettingsPage {
    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Dot", TomlSyntaxHighlighter.DOT),
            new AttributesDescriptor("Comma", TomlSyntaxHighlighter.COMMA),
            new AttributesDescriptor("Equal", TomlSyntaxHighlighter.EQ),
            new AttributesDescriptor("Bracket", TomlSyntaxHighlighter.BRACKET),
            new AttributesDescriptor("Brace", TomlSyntaxHighlighter.BRACE),
            new AttributesDescriptor("Key", TomlSyntaxHighlighter.KEY),
            new AttributesDescriptor("String", TomlSyntaxHighlighter.STRING),
            new AttributesDescriptor("Boolean", TomlSyntaxHighlighter.BOOLEAN),
            new AttributesDescriptor("Date", TomlSyntaxHighlighter.DATE),
            new AttributesDescriptor("Number", TomlSyntaxHighlighter.NUMBER),
            new AttributesDescriptor("Comment", TomlSyntaxHighlighter.COMMENT),
            new AttributesDescriptor("Bad character", TomlSyntaxHighlighter.BAD_CHARACTER),
            new AttributesDescriptor("Table header", TomlSyntaxHighlighter.TABLE_HEADER),
            new AttributesDescriptor("Table array header", TomlSyntaxHighlighter.TABLE_ARRAY_HEADER),
    };

    private static final Map<String, TextAttributesKey> ATTRIBUTES_KEY_MAP = ContainerUtil.newTroveMap();
    static {
        ATTRIBUTES_KEY_MAP.put("th", TomlSyntaxHighlighter.TABLE_HEADER);
        ATTRIBUTES_KEY_MAP.put("tah", TomlSyntaxHighlighter.TABLE_ARRAY_HEADER);
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return TomlIcons.FILE;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new TomlSyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return
        "################################################################################\n"+
        "## Comment\n"+
        "\n"+
        "# Speak your mind with the hash symbol. They go from the symbol to the end of\n"+
        "# the line.\n"+
        "\n"+
        "\n"+
        "################################################################################\n"+
        "## Table\n"+
        "\n"+
        "# Tables (also known as hash tables or dictionaries) are collections of\n"+
        "# key/value pairs. They appear in square brackets on a line by themselves.\n"+
        "\n"+
        "[<th>table</th>]\n"+
        "\n"+
        "key = \"value\" # Yeah, you can do this.\n"+
        "\n"+
        "# Nested tables are denoted by table names with dots in them. Name your tables\n"+
        "# whatever crap you please, just don't use #, ., [ or ].\n"+
        "\n"+
        "[<th>table.subtable</th>]\n"+
        "\n"+
        "key = \"another value\"\n"+
        "\n"+
        "# You don't need to specify all the super-tables if you don't want to. TOML\n"+
        "# knows how to do it for you.\n"+
        "\n"+
        "# [x] you\n"+
        "# [x.y] don't\n"+
        "# [x.y.z] need these\n"+
        "[<th>x.y.z.w</th>] # for this to work\n"+
        "\n"+
        "\n"+
        "################################################################################\n"+
        "## Inline Table\n"+
        "\n"+
        "# Inline tables provide a more compact syntax for expressing tables. They are\n"+
        "# especially useful for grouped data that can otherwise quickly become verbose.\n"+
        "# Inline tables are enclosed in curly braces `{` and `}`. No newlines are\n"+
        "# allowed between the curly braces unless they are valid within a value.\n"+
        "\n"+
        "[<th>table.inline</th>]\n"+
        "\n"+
        "name = { first = \"Tom\", last = \"Preston-Werner\" }\n"+
        "point = { x = 1, y = 2 }\n"+
        "\n"+
        "\n"+
        "################################################################################\n"+
        "## String\n"+
        "\n"+
        "# There are four ways to express strings: basic, multi-line basic, literal, and\n"+
        "# multi-line literal. All strings must contain only valid UTF-8 characters.\n"+
        "\n"+
        "[<th>string.basic</th>]\n"+
        "\n"+
        "basic = \"I'm a string. \\\"You can quote me\\\". Name\\tJos\\u00E9\\nLocation\\tSF.\"\n"+
        "\n"+
        "[<th>string.multiline</th>]\n"+
        "\n"+
        "# The following strings are byte-for-byte equivalent:\n"+
        "key1 = \"One\\nTwo\"\n"+
        "key2 = \"\"\"One\\nTwo\"\"\"\n"+
        "key3 = \"\"\"\n"+
        "One\n"+
        "Two\"\"\"\n"+
        "\n"+
        "[<th>string.multiline.continued</th>]\n"+
        "\n"+
        "# The following strings are byte-for-byte equivalent:\n"+
        "key1 = \"The quick brown fox jumps over the lazy dog.\"\n"+
        "\n"+
        "key2 = \"\"\"\n"+
        "The quick brown \\\n"+
        "  fox jumps over \\\n"+
        "    the lazy dog.\"\"\"\n"+
        "\n"+
        "key3 = \"\"\"\\\n"+
        "       The quick brown \\\n"+
        "       fox jumps over \\\n"+
        "       the lazy dog.\\\n"+
        "       \"\"\"\n"+
        "\n"+
        "[<th>string.literal</th>]\n"+
        "\n"+
        "# What you see is what you get.\n"+
        "winpath  = 'C:\\Users\\nodejs\\templates'\n"+
        "winpath2 = '\\\\ServerX\\admin$\\system32\\'\n"+
        "quoted   = 'Tom \"Dubs\" Preston-Werner'\n"+
        "regex    = '<\\i\\c*\\s*>'\n"+
        "\n"+
        "\n"+
        "[<th>string.literal.multiline</th>]\n"+
        "\n"+
        "regex2 = '''I [dw]on't need \\d{2} apples'''\n"+
        "lines  = '''\n"+
        "The first newline is\n"+
        "trimmed in raw strings.\n"+
        "   All other whitespace\n"+
        "   is preserved.\n"+
        "'''\n"+
        "\n"+
        "\n"+
        "################################################################################\n"+
        "## Integer\n"+
        "\n"+
        "# Integers are whole numbers. Positive numbers may be prefixed with a plus sign.\n"+
        "# Negative numbers are prefixed with a minus sign.\n"+
        "\n"+
        "[<th>integer</th>]\n"+
        "\n"+
        "key1 = +99\n"+
        "key2 = 42\n"+
        "key3 = 0\n"+
        "key4 = -17\n"+
        "\n"+
        "[<th>integer.underscores</th>]\n"+
        "\n"+
        "# For large numbers, you may use underscores to enhance readability. Each\n"+
        "# underscore must be surrounded by at least one digit.\n"+
        "key1 = 1_000\n"+
        "key2 = 5_349_221\n"+
        "key3 = 1_2_3_4_5     # valid but inadvisable\n"+
        "\n"+
        "\n"+
        "################################################################################\n"+
        "## Float\n"+
        "\n"+
        "# A float consists of an integer part (which may be prefixed with a plus or\n"+
        "# minus sign) followed by a fractional part and/or an exponent part.\n"+
        "\n"+
        "[<th>float.fractional</th>]\n"+
        "\n"+
        "key1 = +1.0\n"+
        "key2 = 3.1415\n"+
        "key3 = -0.01\n"+
        "\n"+
        "[<th>float.exponent</th>]\n"+
        "\n"+
        "key1 = 5e+22\n"+
        "key2 = 1e6\n"+
        "key3 = -2E-2\n"+
        "\n"+
        "[<th>float.both</th>]\n"+
        "\n"+
        "key = 6.626e-34\n"+
        "\n"+
        "[<th>float.underscores</th>]\n"+
        "\n"+
        "key1 = 9_224_617.445_991_228_313\n"+
        "key2 = 1e1_000\n"+
        "\n"+
        "\n"+
        "################################################################################\n"+
        "## Boolean\n"+
        "\n"+
        "# Booleans are just the tokens you're used to. Always lowercase.\n"+
        "\n"+
        "[<th>boolean</th>]\n"+
        "\n"+
        "True = true\n"+
        "False = false\n"+
        "\n"+
        "\n"+
        "################################################################################\n"+
        "## Datetime\n"+
        "\n"+
        "# Datetimes are RFC 3339 dates.\n"+
        "\n"+
        "[<th>datetime</th>]\n"+
        "\n"+
        "key1 = 1979-05-27T07:32:00Z\n"+
        "key2 = 1979-05-27T00:32:00-07:00\n"+
        "key3 = 1979-05-27T00:32:00.999999-07:00\n"+
        "\n"+
        "\n"+
        "################################################################################\n"+
        "## Array\n"+
        "\n"+
        "# Arrays are square brackets with other primitives inside. Whitespace is\n"+
        "# ignored. Elements are separated by commas. Data types may not be mixed.\n"+
        "\n"+
        "[<th>array</th>]\n"+
        "\n"+
        "key1 = [ 1, 2, 3 ]\n"+
        "key2 = [ \"red\", \"yellow\", \"green\" ]\n"+
        "key3 = [ [ 1, 2 ], [3, 4, 5] ]\n"+
        "key4 = [ [ 1, 2 ], [\"a\", \"b\", \"c\"] ] # this is ok\n"+
        "\n"+
        "# Arrays can also be multiline. So in addition to ignoring whitespace, arrays\n"+
        "# also ignore newlines between the brackets.  Terminating commas are ok before\n"+
        "# the closing bracket.\n"+
        "\n"+
        "key5 = [\n"+
        "  1, 2, 3\n"+
        "]\n"+
        "key6 = [\n"+
        "  1,\n"+
        "  2, # this is ok\n"+
        "]\n"+
        "\n"+
        "\n"+
        "################################################################################\n"+
        "## Array of Tables\n"+
        "\n"+
        "# These can be expressed by using a table name in double brackets. Each table\n"+
        "# with the same double bracketed name will be an element in the array. The\n"+
        "# tables are inserted in the order encountered.\n"+
        "\n"+
        "[[<tah>products</tah>]]\n"+
        "\n"+
        "name = \"Hammer\"\n"+
        "sku = 738594937\n"+
        "\n"+
        "[[<tah>products</tah>]]\n"+
        "\n"+
        "[[<tah>products</tah>]]\n"+
        "\n"+
        "name = \"Nail\"\n"+
        "sku = 284758393\n"+
        "color = \"gray\"\n"+
        "\n"+
        "\n"+
        "# You can create nested arrays of tables as well.\n"+
        "\n"+
        "[[<tah>fruit</tah>]]\n"+
        "  name = \"apple\"\n"+
        "\n"+
        "  [<th>fruit.physical</th>]\n"+
        "    color = \"red\"\n"+
        "    shape = \"round\"\n"+
        "\n"+
        "  [[<tah>fruit.variety</tah>]]\n"+
        "    name = \"red delicious\"\n"+
        "\n"+
        "  [[<tah>fruit.variety</tah>]]\n"+
        "    name = \"granny smith\"\n"+
        "\n"+
        "[[<tah>fruit</tah>]]\n"+
        "  name = \"banana\"\n"+
        "\n"+
        "  [[<tah>fruit.variety</tah>]]\n"+
        "    name = \"plantain\"";
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return ATTRIBUTES_KEY_MAP;
    }

    @NotNull
    @Override
    public AttributesDescriptor[] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @NotNull
    @Override
    public ColorDescriptor[] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return TomlFileType.INSTANCE.getName();
    }
}
