// This is a generated file. Not intended for manual editing.
package com.tomlidea.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.tomlidea.psi.TomlTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.tomlidea.psi.*;

public class TomlTableArrayImpl extends ASTWrapperPsiElement implements TomlTableArray {

  public TomlTableArrayImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TomlVisitor) ((TomlVisitor)visitor).visitTableArray(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public TomlTableArrayHeader getTableArrayHeader() {
    return findNotNullChildByClass(TomlTableArrayHeader.class);
  }

  @Override
  @NotNull
  public TomlTableEntries getTableEntries() {
    return findNotNullChildByClass(TomlTableEntries.class);
  }

}
