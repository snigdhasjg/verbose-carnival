package com.joe.tree.util;

import com.joe.tree.node.BinaryTreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreePrinterTest {
    @Test
    public void shouldPrintTreeHavingNoChild() {
        BinaryTreeNode<String> rootNode = new BinaryTreeNode<>("Value");
        assertEquals("Value\n", TreePrinter.formatTree(rootNode));
    }

    @Test
    public void shouldPrintTreeHavingRightChild() {
        BinaryTreeNode<String> binaryTreeNode =
                new BinaryTreeNode<>("Value1")
                        .setRight(new BinaryTreeNode<>("Value2"));

        assertEquals("Value1\n└── Value2\n", TreePrinter.formatTree(binaryTreeNode));
    }

    @Test
    public void shouldPrintTreeHavingLeftChild() {
        BinaryTreeNode<String> binaryTreeNode =
                new BinaryTreeNode<>("Value1")
                        .setLeft(new BinaryTreeNode<>("Value2"));

        assertEquals("Value1\n└── Value2\n", TreePrinter.formatTree(binaryTreeNode));
    }

    @Test
    public void shouldPrintTreeHavingBothChild() {
        BinaryTreeNode<String> binaryTreeNode =
                new BinaryTreeNode<>("Value1")
                        .setLeft(new BinaryTreeNode<>("Value2"))
                        .setRight(new BinaryTreeNode<>("Value3"));

        assertEquals("Value1\n├── Value3\n└── Value2\n", TreePrinter.formatTree(binaryTreeNode));
    }
}

