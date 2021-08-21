package com.joe.tree.traversal;

import com.joe.linkedlist.util.NodePrinter;
import com.joe.tree.BinarySearchTree;
import com.joe.tree.node.BinaryTreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TraversalTest {
    private final Traversal<Integer, BinaryTreeNode<Integer>> traversal = new Traversal<>();

    @Test
    void shouldPrintZigZag() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>()
            .add(43).add(18).add(22).add(9).add(21).add(6).add(8).add(20).add(63).add(50).add(62).add(51);

        var linkedNode = traversal.zigZag(tree.getRoot()).getHead();

        assertEquals("head->43<->18<->63<->50<->22<->9<->6<->21<->62<->51<->20<->8<-Tail",
            NodePrinter.formatNode(linkedNode));
    }

    @Test
    void shouldPrintInorder() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>()
            .add(43).add(18).add(22).add(9).add(21).add(6).add(8).add(20).add(63).add(50).add(62).add(51);

        var linkedNode = traversal.inorder(tree.getRoot()).getHead();

        assertEquals("head->6<->8<->9<->18<->20<->21<->22<->43<->50<->51<->62<->63<-Tail",
            NodePrinter.formatNode(linkedNode));
    }
}
