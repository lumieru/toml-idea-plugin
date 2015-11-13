package com.tomlidea.structureview;

import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import com.intellij.navigation.ItemPresentation;
import com.intellij.navigation.NavigationItem;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.util.PsiTreeUtil;
import com.tomlidea.psi.*;

import java.util.ArrayList;
import java.util.List;

public class TomlStructureViewElement implements StructureViewTreeElement, SortableTreeElement {
    private PsiElement element;

    public TomlStructureViewElement(PsiElement element) {
        this.element = element;
    }

    @Override
    public Object getValue() {
        return element;
    }

    @Override
    public void navigate(boolean requestFocus) {
        if (element instanceof NavigationItem) {
            ((NavigationItem) element).navigate(requestFocus);
        }
    }

    @Override
    public boolean canNavigate() {
        return element instanceof NavigationItem &&
                ((NavigationItem)element).canNavigate();
    }

    @Override
    public boolean canNavigateToSource() {
        return element instanceof NavigationItem &&
                ((NavigationItem)element).canNavigateToSource();
    }

    @Override
    public String getAlphaSortKey() {
        return element instanceof PsiNamedElement ? ((PsiNamedElement) element).getName() : null;
    }

    @Override
    public ItemPresentation getPresentation() {
        return element instanceof NavigationItem ?
                ((NavigationItem) element).getPresentation() : null;
    }

    @Override
    public TreeElement[] getChildren() {
        if (element instanceof TomlFile) {
            TomlExpression[] exps = PsiTreeUtil.getChildrenOfType(element, TomlExpression.class);
            List<TreeElement> treeElements = new ArrayList<TreeElement>(exps.length);
            for (TomlExpression exp : exps) {
                PsiElement child;
                if(exp.getTable() != null) {
                    child = exp.getTable();
                } else if(exp.getTableArray() != null) {
                    child = exp.getTableArray();
                } else {
                    child = exp.getKeyValue();
                }
                treeElements.add(new TomlStructureViewElement(child));
            }
            return treeElements.toArray(new TreeElement[treeElements.size()]);
        } else if(element instanceof TomlTable) {
            return getTableEntries(((TomlTable)element).getTableEntries());
        } else if(element instanceof  TomlTableArray) {
            return getTableEntries(((TomlTableArray)element).getTableEntries());
        } else {
            return EMPTY_ARRAY;
        }
    }

    private TreeElement[] getTableEntries(TomlTableEntries entries) {
        if(entries != null) {
            List<TomlKeyValue> keyValues = entries.getKeyValueList();
            if(keyValues != null && keyValues.size() > 0) {
                List<TreeElement> treeElements = new ArrayList<TreeElement>(keyValues.size());
                for(TomlKeyValue kv : keyValues) {
                    treeElements.add(new TomlStructureViewElement(kv));
                }
                return treeElements.toArray(new TreeElement[treeElements.size()]);
            } else {
                return EMPTY_ARRAY;
            }
        } else {
            return EMPTY_ARRAY;
        }
    }
}
