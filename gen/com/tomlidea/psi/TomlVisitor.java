// This is a generated file. Not intended for manual editing.
package com.tomlidea.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class TomlVisitor extends PsiElementVisitor {

  public void visitArray(@NotNull TomlArray o) {
    visitPsiElement(o);
  }

  public void visitDates(@NotNull TomlDates o) {
    visitPsiElement(o);
  }

  public void visitExpression(@NotNull TomlExpression o) {
    visitPsiElement(o);
  }

  public void visitInlineTable(@NotNull TomlInlineTable o) {
    visitPsiElement(o);
  }

  public void visitKey(@NotNull TomlKey o) {
    visitPsiElement(o);
  }

  public void visitKeyValue(@NotNull TomlKeyValue o) {
    visitNamedElement(o);
  }

  public void visitNumbers(@NotNull TomlNumbers o) {
    visitPsiElement(o);
  }

  public void visitPath(@NotNull TomlPath o) {
    visitPsiElement(o);
  }

  public void visitSqmcharstr(@NotNull TomlSqmcharstr o) {
    visitPsiElement(o);
  }

  public void visitString(@NotNull TomlString o) {
    visitPsiElement(o);
  }

  public void visitTable(@NotNull TomlTable o) {
    visitNamedElement(o);
  }

  public void visitTableArray(@NotNull TomlTableArray o) {
    visitNamedElement(o);
  }

  public void visitTableArrayHeader(@NotNull TomlTableArrayHeader o) {
    visitPsiElement(o);
  }

  public void visitTableEntries(@NotNull TomlTableEntries o) {
    visitPsiElement(o);
  }

  public void visitTableHeader(@NotNull TomlTableHeader o) {
    visitPsiElement(o);
  }

  public void visitValue(@NotNull TomlValue o) {
    visitPsiElement(o);
  }

  public void visitNamedElement(@NotNull TomlNamedElement o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
