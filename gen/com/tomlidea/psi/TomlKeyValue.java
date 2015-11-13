// This is a generated file. Not intended for manual editing.
package com.tomlidea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.navigation.ItemPresentation;

public interface TomlKeyValue extends TomlNamedElement {

  @NotNull
  TomlKey getKey();

  @NotNull
  TomlValue getValue();

  String getName();

  PsiElement setName(String newName);

  PsiElement getNameIdentifier();

  ItemPresentation getPresentation();

}
