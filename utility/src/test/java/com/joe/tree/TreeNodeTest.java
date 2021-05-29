package com.joe.tree;

import com.joe.tree.node.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TreeNodeTest {

    @Test
    void shouldConstructATreeWith2Child() {
        TreeNode<Integer> treeNode = new TreeNode<>(1)
                .setLeft(new TreeNode<>(2))
                .setRight(new TreeNode<>(3));

        assertAll(
                () -> assertEquals(1, treeNode.getValue()),
                () -> assertEquals(2, treeNode.getLeft().getValue()),
                () -> assertEquals(3, treeNode.getRight().getValue())
        );
    }
}