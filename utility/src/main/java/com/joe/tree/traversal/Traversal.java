package com.joe.tree.traversal;

import com.joe.datastructure.Queue;
import com.joe.linkedlist.DoublyLinkedList;
import com.joe.tree.node.IBinaryTreeNode;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class Traversal<T extends Comparable<T>, U extends IBinaryTreeNode<T, U>> {

    public DoublyLinkedList<U> zigZag(U root) {
        Queue<U> queue = Queue.defaultQueue();
        queue.enqueue(root);
        return zigZagTraverse(queue, false);
    }

    public DoublyLinkedList<U> inorder(U root) {
        DoublyLinkedList<U> orderedList = new DoublyLinkedList<>();
        inorderTraverse(root, orderedList);
        return orderedList;
    }

    private void inorderTraverse(U currentNode, DoublyLinkedList<U> outputOrderedList) {
        if (isNull(currentNode)) {
            return;
        }
        inorderTraverse(currentNode.getLeft(), outputOrderedList);
        outputOrderedList.add(currentNode);
        inorderTraverse(currentNode.getRight(), outputOrderedList);
    }

    private DoublyLinkedList<U> zigZagTraverse(Queue<U> previousLevel, boolean swapDirection) {
        if (previousLevel.isEmpty()) {
            return new DoublyLinkedList<>();
        }
        Queue<U> currentLevel = Queue.defaultQueue();
        DoublyLinkedList<U> previousLevelList = new DoublyLinkedList<>();
        while (!previousLevel.isEmpty()) {
            U pop = previousLevel.dequeue();

            if (swapDirection) {
                previousLevelList.add(pop);
            } else {
                previousLevelList.addFirst(pop);
            }

            if (nonNull(pop.getLeft())) {
                currentLevel.enqueue(pop.getLeft());
            }
            if (nonNull(pop.getRight())) {
                currentLevel.enqueue(pop.getRight());
            }
        }
        return previousLevelList.add(zigZagTraverse(currentLevel, !swapDirection));
    }
}
