// This is a generated file. Not intended for manual editing.
package com.tomlidea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface TomlExpression extends PsiElement {

  @Nullable
  TomlKeyValue getKeyValue();

  @Nullable
  TomlTable getTable();

  @Nullable
  TomlTableArray getTableArray();

}
