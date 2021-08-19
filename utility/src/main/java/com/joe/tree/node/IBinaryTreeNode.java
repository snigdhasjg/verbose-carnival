package com.joe.tree.node;

public interface IBinaryTreeNode<T> {
    T getValue();

    IBinaryTreeNode<T> getLeft();

    IBinaryTreeNode<T> getRight();
}
