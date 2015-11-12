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

public class TomlStringImpl extends ASTWrapperPsiElement implements TomlString {

  public TomlStringImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TomlVisitor) ((TomlVisitor)visitor).visitString(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public TomlSqmcharstr getSqmcharstr() {
    return findChildByClass(TomlSqmcharstr.class);
  }

  @Override
  @Nullable
  public PsiElement getDqmstring() {
    return findChildByType(DQMSTRING);
  }

  @Override
  @Nullable
  public PsiElement getDqsstring() {
    return findChildByType(DQSSTRING);
  }

  @Override
  @Nullable
  public PsiElement getSqmstring() {
    return findChildByType(SQMSTRING);
  }

  @Override
  @Nullable
  public PsiElement getSqsstring() {
    return findChildByType(SQSSTRING);
  }

}
