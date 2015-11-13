package com.tomlidea.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import com.tomlidea.TomlIcons;
import com.tomlidea.psi.*;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class TomlPsiImplUtil {
    //get name for TomlKeyValue
    public static String getName(TomlKeyValue element) {
        ASTNode keyNode = element.getNode().findChildByType(TomlTypes.KEY);
        if (keyNode != null) {
            return keyNode.getText();
        } else {
            return null;
        }
    }

    //get name for TomlTable
    public static String getName(TomlTable element) {
        PsiElement path = element.getTableHeader().getPath();
        ASTNode pathNode = path.getNode();
        if (pathNode != null) {
            return pathNode.getText();
        } else {
            return null;
        }
    }

    //get name for TomlTableArray
    public static String getName(TomlTableArray element) {
        PsiElement path = element.getTableArrayHeader().getPath();
        ASTNode pathNode = path.getNode();
        if (pathNode != null) {
            return pathNode.getText();
        } else {
            return null;
        }
    }

    //set name for TomlKeyValue
    public static PsiElement setName(TomlKeyValue element, String newName) {
        //not implemented
        return element;
    }

    //set name for TomlTable
    public static PsiElement setName(TomlTable element, String newName) {
        //not implemented
        return element;
    }

    //set name for TomlTableArray
    public static PsiElement setName(TomlTableArray element, String newName) {
        //not implemented
        return element;
    }

    //getNameIdentifier for TomlKeyValue
    public static PsiElement getNameIdentifier(TomlKeyValue element) {
        ASTNode keyNode = element.getKey().getNode();
        if (keyNode != null) {
            return keyNode.getPsi();
        } else {
            return null;
        }
    }

    //getNameIdentifier for TomlTable
    public static PsiElement getNameIdentifier(TomlTable element) {
        PsiElement path = element.getTableHeader().getPath();
        ASTNode pathNode = path.getNode();
        if (pathNode != null) {
            return pathNode.getPsi();
        } else {
            return null;
        }
    }

    //getNameIdentifier for TomlTableArray
    public static PsiElement getNameIdentifier(TomlTableArray element) {
        PsiElement path = element.getTableArrayHeader().getPath();
        ASTNode pathNode = path.getNode();
        if (pathNode != null) {
            return pathNode.getPsi();
        } else {
            return null;
        }
    }

    //getPresentation for TomlKeyValue
    public static ItemPresentation getPresentation(final TomlKeyValue element) {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                return element.getName();
            }

            @Nullable
            @Override
            public String getLocationString() {
                return null;
            }

            @Nullable
            @Override
            public Icon getIcon(boolean unused) {
                return TomlIcons.KEY;
            }
        };
    }

    //getPresentation for TomlTable
    public static ItemPresentation getPresentation(final TomlTable element) {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                return element.getName();
            }

            @Nullable
            @Override
            public String getLocationString() {
                return null;
            }

            @Nullable
            @Override
            public Icon getIcon(boolean unused) {
                return TomlIcons.TABLE;
            }
        };
    }

    //getPresentation for TomlTableArray
    public static ItemPresentation getPresentation(final TomlTableArray element) {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                return element.getName();
            }

            @Nullable
            @Override
            public String getLocationString() {
                return null;
            }

            @Nullable
            @Override
            public Icon getIcon(boolean unused) {
                return TomlIcons.TABLE_ARRAY;
            }
        };
    }
}
