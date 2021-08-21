package com.joe.tree;

import com.joe.tree.node.AVLTreeNode;
import com.joe.tree.rotator.AVLTreeRotator;

public class AVLTree<T extends Comparable<T>> extends AbstractBinarySearchTree<T, AVLTreeNode<T>, AVLTree<T>> {
    private final AVLTreeRotator<T> avlTreeRotator = new AVLTreeRotator<>();

    @Override
    public void remove(T value) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    protected AVLTreeNode<T> newInstance(T value) {
        return new AVLTreeNode<>(value);
    }

    @Override
    protected AVLTreeNode<T> postAdd(AVLTreeNode<T> currentNode, AVLTreeNode<T> nodeToAdd) {
        currentNode.updateHeight();
        return avlTreeRotator.rotateIfPossible(currentNode, nodeToAdd);
    }
}
