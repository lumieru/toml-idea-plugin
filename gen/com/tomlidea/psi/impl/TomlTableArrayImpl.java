// This is a generated file. Not intended for manual editing.
package com.tomlidea.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.tomlidea.psi.TomlTypes.*;
import com.tomlidea.psi.*;
import com.intellij.navigation.ItemPresentation;

public class TomlTableArrayImpl extends TomlNamedElementImpl implements TomlTableArray {

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

  public String getName() {
    return TomlPsiImplUtil.getName(this);
  }

  public PsiElement setName(String newName) {
    return TomlPsiImplUtil.setName(this, newName);
  }

  public PsiElement getNameIdentifier() {
    return TomlPsiImplUtil.getNameIdentifier(this);
  }

  public ItemPresentation getPresentation() {
    return TomlPsiImplUtil.getPresentation(this);
  }

}
