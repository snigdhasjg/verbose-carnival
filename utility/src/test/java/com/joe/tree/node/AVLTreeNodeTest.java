package com.joe.tree.node;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SuppressWarnings("unchecked")
class AVLTreeNodeTest {
    private final AVLTreeNode<Integer> left = mock(AVLTreeNode.class);
    private final AVLTreeNode<Integer> right = mock(AVLTreeNode.class);
    private final AVLTreeNode<Integer> node = new AVLTreeNode<>(0)
        .setLeft(left)
        .setRight(right);

    @Test
    void shouldReturnHeightAsMaxOfLeftAndRightChildAndBalanceAsLeftMinusRight1() {
        when(left.getHeight()).thenReturn(7);
        when(right.getHeight()).thenReturn(1);

        node.updateHeight();
        int balance = node.getBalance();

        assertEquals(8, node.getHeight());
        assertEquals(6, balance);
        assertEquals("⁷ 0 ¹", node.toString());
    }

    @Test
    void shouldReturnHeightAsMaxOfLeftAndRightChildAndBalanceAsLeftMinusRight2() {
        when(left.getHeight()).thenReturn(5);
        when(right.getHeight()).thenReturn(9);

        node.updateHeight();
        int balance = node.getBalance();

        assertEquals(10, node.getHeight());
        assertEquals(-4, balance);
        assertEquals("⁵ 0 ⁹", node.toString());
    }

    @Test
    void shouldCalculateHeightBalanceIfLeftIsNull() {
        when(right.getHeight()).thenReturn(2);
        node.setLeft(null);

        node.updateHeight();
        int balance = node.getBalance();

        assertEquals(3, node.getHeight());
        assertEquals(-2, balance);
        assertEquals("⁰ 0 ²", node.toString());
    }

    @Test
    void shouldCalculateHeightBalanceIfRightIsNull() {
        when(left.getHeight()).thenReturn(3);
        node.setRight(null);

        node.updateHeight();
        int balance = node.getBalance();

        assertEquals(4, node.getHeight());
        assertEquals(3, balance);
        assertEquals("³ 0 ⁰", node.toString());
    }

    @Test
    void shouldCalculateHeightBalanceIfLeftRightBothIsNull() {
        node.setRight(null);
        node.setLeft(null);

        node.updateHeight();
        int balance = node.getBalance();

        assertEquals(1, node.getHeight());
        assertEquals(0, balance);
        assertEquals("⁰ 0 ⁰", node.toString());
    }


    @Test
    void shouldCompareWithEachOther() {
        assertEquals(-1, new AVLTreeNode<>(1).compareTo(new AVLTreeNode<>(3)));
    }
}
