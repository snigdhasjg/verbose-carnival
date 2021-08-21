package com.joe.tree;

import com.joe.tree.node.BinaryTreeNode;
import lombok.Getter;

@Getter
public class BinarySearchTree<T extends Comparable<T>>
    extends AbstractBinarySearchTree<T, BinaryTreeNode<T>, BinarySearchTree<T>> {

    @Override
    protected BinaryTreeNode<T> newInstance(T value) {
        return new BinaryTreeNode<>(value);
    }

    @Override
    protected BinaryTreeNode<T> postAdd(BinaryTreeNode<T> currentNode, BinaryTreeNode<T> nodeToAdd) {
        return currentNode;
    }
}
