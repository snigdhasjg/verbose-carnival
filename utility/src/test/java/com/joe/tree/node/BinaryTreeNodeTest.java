package com.joe.tree.node;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreeNodeTest {

    @Test
    void shouldConstructATreeWith2Child() {
        BinaryTreeNode<Integer> binaryTreeNode = new BinaryTreeNode<>(1)
                .setLeft(new BinaryTreeNode<>(2))
                .setRight(new BinaryTreeNode<>(3));

        assertAll(
                () -> assertEquals(1, binaryTreeNode.getValue()),
                () -> assertEquals(2, binaryTreeNode.getLeft().getValue()),
                () -> assertEquals(3, binaryTreeNode.getRight().getValue())
        );
    }

    @Test
    void shouldCompareWithEachOther() {
        assertEquals(-1, new BinaryTreeNode<>(1).compareTo(new BinaryTreeNode<>(2)));
    }
}
