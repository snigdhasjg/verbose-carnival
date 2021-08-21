package com.joe.tree.node;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
@EqualsAndHashCode
public class BinaryTreeNode<T extends Comparable<T>> implements IBinaryTreeNode<T, BinaryTreeNode<T>> {

    @Setter
    @NonNull
    private T value;
    @EqualsAndHashCode.Exclude
    private BinaryTreeNode<T> left;
    @EqualsAndHashCode.Exclude
    private BinaryTreeNode<T> right;

    public BinaryTreeNode<T> setLeft(BinaryTreeNode<T> left) {
        this.left = left;
        return this;
    }

    public BinaryTreeNode<T> setRight(BinaryTreeNode<T> right) {
        this.right = right;
        return this;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public int compareTo(BinaryTreeNode<T> o) {
        return this.value.compareTo(o.value);
    }
}
