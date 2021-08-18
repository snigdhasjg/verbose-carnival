package com.joe.tree.node;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
        TestCompare object1 = mock(TestCompare.class);
        TestCompare object2 = mock(TestCompare.class);
        when(object1.compareTo(object2)).thenReturn(7);

        assertEquals(7, new BinaryTreeNode<>(object1).compareTo(new BinaryTreeNode<>(object2)));
    }

    private static class TestCompare implements Comparable<TestCompare> {
        @Override
        public int compareTo(TestCompare o) {
            return 0;
        }
    }
}
