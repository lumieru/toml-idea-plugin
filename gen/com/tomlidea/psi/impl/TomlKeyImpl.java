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

public class TomlKeyImpl extends ASTWrapperPsiElement implements TomlKey {

  public TomlKeyImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TomlVisitor) ((TomlVisitor)visitor).visitKey(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getBarekey() {
    return findChildByType(BAREKEY);
  }

  @Override
  @Nullable
  public PsiElement getDqsstring() {
    return findChildByType(DQSSTRING);
  }

}
