package com.joe.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BinarySearchTreeTest {
    @Test
    void shouldConstructABinarySearchTree() {
        BinarySearchTree<Double> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.add(5.6).add(3.4).add(5.1).add(1.2).add(8.6).add(7.9);

        String treeStructure
                = "5.6\n" +
                "├── 8.6\n" +
                "│   └── 7.9\n" +
                "└── 3.4\n" +
                "\t├── 5.1\n" +
                "\t└── 1.2\n";
        assertEquals(treeStructure, binarySearchTree.toString());
    }

    @Test
    void shouldFindInOrderSuccessorForMiddleNode() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.add(20).add(8).add(22).add(4).add(12).add(10).add(14);

        assertEquals(10, binarySearchTree.getInOrderSuccessor(8));
        assertEquals(14, binarySearchTree.getInOrderSuccessor(12));
        assertEquals(20, binarySearchTree.getInOrderSuccessor(14));
        assertEquals(22, binarySearchTree.getInOrderSuccessor(20));
        assertNull(binarySearchTree.getInOrderSuccessor(22));
    }

    @Test
    void shouldDeleteNodeForLeaf() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.add(20);
        binarySearchTree.remove(20);

        assertTrue(binarySearchTree.isEmpty());
    }

    @Test
    void shouldDeleteNodeHavingOnlyOneLeftChild() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.add(20).add(10);
        binarySearchTree.remove(20);

        assertEquals("10\n", binarySearchTree.toString());
    }

    @Test
    void shouldDeleteNodeHavingOnlyOneRightChild() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.add(20).add(30);
        binarySearchTree.remove(20);

        assertEquals("30\n", binarySearchTree.toString());
    }

    @Test
    void shouldDeleteNodeHavingBothTheChild() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.add(20).add(10).add(30).add(25).add(40);
        binarySearchTree.remove(20);

        String treeStructure
                = "25\n" +
                "├── 30\n" +
                "│   └── 40\n" +
                "└── 10\n";
        assertEquals(treeStructure, binarySearchTree.toString());
    }
}
