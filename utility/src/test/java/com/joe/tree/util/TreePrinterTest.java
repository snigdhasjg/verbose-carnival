package com.joe.tree.util;

import com.joe.tree.node.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreePrinterTest {
    @Test
    public void shouldPrintTreeHavingNoChild() {
        TreeNode<String> rootNode = new TreeNode<>("Value");
        assertEquals("Value\n", TreePrinter.formatTree(rootNode));
    }

    @Test
    public void shouldPrintTreeHavingRightChild() {
        TreeNode<String> treeNode =
                new TreeNode<>("Value1")
                        .setRight(new TreeNode<>("Value2"));

        assertEquals("Value1\n└── Value2\n", TreePrinter.formatTree(treeNode));
    }

    @Test
    public void shouldPrintTreeHavingLeftChild() {
        TreeNode<String> treeNode =
                new TreeNode<>("Value1")
                        .setLeft(new TreeNode<>("Value2"));

        assertEquals("Value1\n└── Value2\n", TreePrinter.formatTree(treeNode));
    }

    @Test
    public void shouldPrintTreeHavingBothChild() {
        TreeNode<String> treeNode =
                new TreeNode<>("Value1")
                        .setLeft(new TreeNode<>("Value2"))
                        .setRight(new TreeNode<>("Value3"));

        assertEquals("Value1\n├── Value2\n└── Value3\n", TreePrinter.formatTree(treeNode));
    }
}

