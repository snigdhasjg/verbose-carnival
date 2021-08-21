package com.joe.tree.node;

public interface IBinaryTreeNode<T, U extends IBinaryTreeNode<T, U>> extends Comparable<U> {
    T getValue();

    U getLeft();

    U getRight();

    void setValue(T value);

    U setLeft(U node);

    U setRight(U node);
}
