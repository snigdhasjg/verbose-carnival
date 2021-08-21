package com.joe.tree.rotator;

import com.joe.tree.node.BinaryTreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TreeRotatorTest {
    private final TreeRotator<Integer, BinaryTreeNode<Integer>> treeRotator = new TreeRotator<>() {
        @Override
        protected void postRotation(BinaryTreeNode<Integer> grandParent, BinaryTreeNode<Integer> parent) {
            // Nothing
        }
    };
    private BinaryTreeNode<Integer> grandParent;
    private BinaryTreeNode<Integer> parent;
    private BinaryTreeNode<Integer> child;

    @BeforeEach
    void setUp() {
        grandParent = new BinaryTreeNode<>(1);
        parent = new BinaryTreeNode<>(2);
        child = new BinaryTreeNode<>(3);
    }

    @Test
    void shouldLeftRotateTheTree() {
        grandParent.setRight(parent.setRight(child));

        BinaryTreeNode<Integer> leftRotation = treeRotator.leftRotation(grandParent);
        assertEquals(parent, leftRotation);
        assertEquals(grandParent, leftRotation.getLeft());
        assertEquals(child, leftRotation.getRight());

        BinaryTreeNode<Integer> againLeftRotation = treeRotator.leftRotation(parent);
        assertEquals(child, againLeftRotation);
        assertEquals(parent, againLeftRotation.getLeft());
        assertEquals(grandParent, againLeftRotation.getLeft().getLeft());
    }

    @Test
    void shouldRightRotateTheTree() {
        grandParent.setLeft(parent.setLeft(child));

        BinaryTreeNode<Integer> rightRotation = treeRotator.rightRotation(grandParent);
        assertEquals(parent, rightRotation);
        assertEquals(grandParent, rightRotation.getRight());
        assertEquals(child, rightRotation.getLeft());

        BinaryTreeNode<Integer> againRightRotation = treeRotator.rightRotation(parent);
        assertEquals(child, againRightRotation);
        assertEquals(parent, againRightRotation.getRight());
        assertEquals(grandParent, againRightRotation.getRight().getRight());
    }

    @Test
    void shouldRotateLeftOfParentAndRightOfGrandParent() {
        grandParent.setLeft(parent.setRight(child));

        BinaryTreeNode<Integer> leftRightRotation = treeRotator.leftRightRotation(grandParent);
        assertEquals(child, leftRightRotation);
        assertEquals(grandParent, leftRightRotation.getRight());
        assertEquals(parent, leftRightRotation.getLeft());
    }
}
