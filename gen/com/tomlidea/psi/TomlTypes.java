// This is a generated file. Not intended for manual editing.
package com.tomlidea.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.tomlidea.psi.impl.*;

public interface TomlTypes {

  IElementType ARRAY = new TomlElementType("ARRAY");
  IElementType EXPRESSION = new TomlElementType("EXPRESSION");
  IElementType INLINE_TABLE = new TomlElementType("INLINE_TABLE");
  IElementType KEY = new TomlElementType("KEY");
  IElementType KEY_VALUE = new TomlElementType("KEY_VALUE");
  IElementType PATH = new TomlElementType("PATH");
  IElementType STRING = new TomlElementType("STRING");
  IElementType TABLE = new TomlElementType("TABLE");
  IElementType TABLE_ARRAY = new TomlElementType("TABLE_ARRAY");
  IElementType TABLE_ARRAY_HEADER = new TomlElementType("TABLE_ARRAY_HEADER");
  IElementType TABLE_ENTRIES = new TomlElementType("TABLE_ENTRIES");
  IElementType TABLE_HEADER = new TomlElementType("TABLE_HEADER");
  IElementType VALUE = new TomlElementType("VALUE");

  IElementType BAREKEY = new TomlTokenType("barekey");
  IElementType BOOLEAN = new TomlTokenType("boolean");
  IElementType COMMA = new TomlTokenType(",");
  IElementType COMMENT = new TomlTokenType("comment");
  IElementType DATE = new TomlTokenType("date");
  IElementType DOT = new TomlTokenType(".");
  IElementType DQMSTRING = new TomlTokenType("dqmstring");
  IElementType DQSSTRING = new TomlTokenType("dqsstring");
  IElementType EQ = new TomlTokenType("=");
  IElementType LBRACE = new TomlTokenType("{");
  IElementType LBRACKET = new TomlTokenType("[");
  IElementType NUMBER = new TomlTokenType("number");
  IElementType RBRACE = new TomlTokenType("}");
  IElementType RBRACKET = new TomlTokenType("]");
  IElementType SQMSTRING = new TomlTokenType("sqmstring");
  IElementType SQSSTRING = new TomlTokenType("sqsstring");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == ARRAY) {
        return new TomlArrayImpl(node);
      }
      else if (type == EXPRESSION) {
        return new TomlExpressionImpl(node);
      }
      else if (type == INLINE_TABLE) {
        return new TomlInlineTableImpl(node);
      }
      else if (type == KEY) {
        return new TomlKeyImpl(node);
      }
      else if (type == KEY_VALUE) {
        return new TomlKeyValueImpl(node);
      }
      else if (type == PATH) {
        return new TomlPathImpl(node);
      }
      else if (type == STRING) {
        return new TomlStringImpl(node);
      }
      else if (type == TABLE) {
        return new TomlTableImpl(node);
      }
      else if (type == TABLE_ARRAY) {
        return new TomlTableArrayImpl(node);
      }
      else if (type == TABLE_ARRAY_HEADER) {
        return new TomlTableArrayHeaderImpl(node);
      }
      else if (type == TABLE_ENTRIES) {
        return new TomlTableEntriesImpl(node);
      }
      else if (type == TABLE_HEADER) {
        return new TomlTableHeaderImpl(node);
      }
      else if (type == VALUE) {
        return new TomlValueImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
