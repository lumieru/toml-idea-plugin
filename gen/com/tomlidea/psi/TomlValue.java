// This is a generated file. Not intended for manual editing.
package com.tomlidea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface TomlValue extends PsiElement {

  @Nullable
  TomlArray getArray();

  @Nullable
  TomlInlineTable getInlineTable();

  @Nullable
  TomlString getString();

  @Nullable
  PsiElement getBoolean();

  @Nullable
  PsiElement getDate();

  @Nullable
  PsiElement getNumber();

}
