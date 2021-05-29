package com.joe.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTreeTest {
    @Test
    void shouldConstructABinarySearchTree() {
        BinarySearchTree<Double> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.addNode(5.6).addNode(3.4).addNode(5.1).addNode(1.2).addNode(8.6).addNode(7.9);

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
        binarySearchTree.addNode(20).addNode(8).addNode(22).addNode(4).addNode(12).addNode(10).addNode(14);

        assertEquals(10, binarySearchTree.getInOrderSuccessor(8));
        assertEquals(12, binarySearchTree.getInOrderSuccessor(12));
        assertEquals(12, binarySearchTree.getInOrderSuccessor(14));
        assertEquals(14, binarySearchTree.getInOrderSuccessor(20));
        assertEquals(20, binarySearchTree.getInOrderSuccessor(22));
        assertEquals(20, binarySearchTree.getInOrderSuccessor(14));
    }
}