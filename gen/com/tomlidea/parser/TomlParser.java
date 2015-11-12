// This is a generated file. Not intended for manual editing.
package com.tomlidea.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.tomlidea.psi.TomlTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class TomlParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == ARRAY) {
      r = array(b, 0);
    }
    else if (t == EXPRESSION) {
      r = expression(b, 0);
    }
    else if (t == INLINE_TABLE) {
      r = inline_table(b, 0);
    }
    else if (t == KEY) {
      r = key(b, 0);
    }
    else if (t == KEY_VALUE) {
      r = key_value(b, 0);
    }
    else if (t == PATH) {
      r = path(b, 0);
    }
    else if (t == STRING) {
      r = string(b, 0);
    }
    else if (t == TABLE) {
      r = table(b, 0);
    }
    else if (t == TABLE_ARRAY) {
      r = table_array(b, 0);
    }
    else if (t == TABLE_ARRAY_HEADER) {
      r = table_array_header(b, 0);
    }
    else if (t == TABLE_ENTRIES) {
      r = table_entries(b, 0);
    }
    else if (t == TABLE_HEADER) {
      r = table_header(b, 0);
    }
    else if (t == VALUE) {
      r = value(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return tomlFile(b, l + 1);
  }

  /* ********************************************************** */
  // '[' (value (',' value)* ','?)? ']'
  public static boolean array(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array")) return false;
    if (!nextTokenIs(b, LBRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACKET);
    r = r && array_1(b, l + 1);
    r = r && consumeToken(b, RBRACKET);
    exit_section_(b, m, ARRAY, r);
    return r;
  }

  // (value (',' value)* ','?)?
  private static boolean array_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_1")) return false;
    array_1_0(b, l + 1);
    return true;
  }

  // value (',' value)* ','?
  private static boolean array_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = value(b, l + 1);
    r = r && array_1_0_1(b, l + 1);
    r = r && array_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' value)*
  private static boolean array_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_1_0_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!array_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "array_1_0_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' value
  private static boolean array_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ','?
  private static boolean array_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_1_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // key_value | table | table_array
  public static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<expression>");
    r = key_value(b, l + 1);
    if (!r) r = table(b, l + 1);
    if (!r) r = table_array(b, l + 1);
    exit_section_(b, l, m, EXPRESSION, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '{' (key_value (',' key_value)* ','?)? '}'
  public static boolean inline_table(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inline_table")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && inline_table_1(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, INLINE_TABLE, r);
    return r;
  }

  // (key_value (',' key_value)* ','?)?
  private static boolean inline_table_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inline_table_1")) return false;
    inline_table_1_0(b, l + 1);
    return true;
  }

  // key_value (',' key_value)* ','?
  private static boolean inline_table_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inline_table_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = key_value(b, l + 1);
    r = r && inline_table_1_0_1(b, l + 1);
    r = r && inline_table_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' key_value)*
  private static boolean inline_table_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inline_table_1_0_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!inline_table_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "inline_table_1_0_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' key_value
  private static boolean inline_table_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inline_table_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && key_value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ','?
  private static boolean inline_table_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inline_table_1_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // barekey | dqsstring
  public static boolean key(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key")) return false;
    if (!nextTokenIs(b, "<key>", BAREKEY, DQSSTRING)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<key>");
    r = consumeToken(b, BAREKEY);
    if (!r) r = consumeToken(b, DQSSTRING);
    exit_section_(b, l, m, KEY, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // key '=' value
  public static boolean key_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_value")) return false;
    if (!nextTokenIs(b, "<key value>", BAREKEY, DQSSTRING)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<key value>");
    r = key(b, l + 1);
    r = r && consumeToken(b, EQ);
    r = r && value(b, l + 1);
    exit_section_(b, l, m, KEY_VALUE, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // key ('.' key) *
  public static boolean path(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path")) return false;
    if (!nextTokenIs(b, "<path>", BAREKEY, DQSSTRING)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<path>");
    r = key(b, l + 1);
    r = r && path_1(b, l + 1);
    exit_section_(b, l, m, PATH, r, false, null);
    return r;
  }

  // ('.' key) *
  private static boolean path_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!path_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "path_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // '.' key
  private static boolean path_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT);
    r = r && key(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // dqmstring | sqmstring | dqsstring | sqsstring
  public static boolean string(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<string>");
    r = consumeToken(b, DQMSTRING);
    if (!r) r = consumeToken(b, SQMSTRING);
    if (!r) r = consumeToken(b, DQSSTRING);
    if (!r) r = consumeToken(b, SQSSTRING);
    exit_section_(b, l, m, STRING, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // table_header table_entries
  public static boolean table(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "table")) return false;
    if (!nextTokenIs(b, LBRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = table_header(b, l + 1);
    r = r && table_entries(b, l + 1);
    exit_section_(b, m, TABLE, r);
    return r;
  }

  /* ********************************************************** */
  // table_array_header table_entries
  public static boolean table_array(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "table_array")) return false;
    if (!nextTokenIs(b, LBRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = table_array_header(b, l + 1);
    r = r && table_entries(b, l + 1);
    exit_section_(b, m, TABLE_ARRAY, r);
    return r;
  }

  /* ********************************************************** */
  // '[' '[' path ']' ']'
  public static boolean table_array_header(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "table_array_header")) return false;
    if (!nextTokenIs(b, LBRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACKET);
    r = r && consumeToken(b, LBRACKET);
    r = r && path(b, l + 1);
    r = r && consumeToken(b, RBRACKET);
    r = r && consumeToken(b, RBRACKET);
    exit_section_(b, m, TABLE_ARRAY_HEADER, r);
    return r;
  }

  /* ********************************************************** */
  // key_value *
  public static boolean table_entries(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "table_entries")) return false;
    Marker m = enter_section_(b, l, _NONE_, "<table entries>");
    int c = current_position_(b);
    while (true) {
      if (!key_value(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "table_entries", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, TABLE_ENTRIES, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // '[' path ']'
  public static boolean table_header(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "table_header")) return false;
    if (!nextTokenIs(b, LBRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACKET);
    r = r && path(b, l + 1);
    r = r && consumeToken(b, RBRACKET);
    exit_section_(b, m, TABLE_HEADER, r);
    return r;
  }

  /* ********************************************************** */
  // expression *
  static boolean tomlFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tomlFile")) return false;
    int c = current_position_(b);
    while (true) {
      if (!expression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "tomlFile", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // string | number | boolean | date | array | inline_table
  public static boolean value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<value>");
    r = string(b, l + 1);
    if (!r) r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, BOOLEAN);
    if (!r) r = consumeToken(b, DATE);
    if (!r) r = array(b, l + 1);
    if (!r) r = inline_table(b, l + 1);
    exit_section_(b, l, m, VALUE, r, false, null);
    return r;
  }

}
