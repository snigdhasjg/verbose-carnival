package com.joe.tree.node;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class BinaryTreeNode<T extends Comparable<T>> implements Comparable<BinaryTreeNode<T>> {
    @Setter
    private @NonNull T value;
    private @EqualsAndHashCode.Exclude @ToString.Exclude
    BinaryTreeNode<T> left;
    private @EqualsAndHashCode.Exclude @ToString.Exclude
    BinaryTreeNode<T> right;

    public BinaryTreeNode<T> setLeft(BinaryTreeNode<T> left) {
        this.left = left;
        return this;
    }

    public BinaryTreeNode<T> setRight(BinaryTreeNode<T> right) {
        this.right = right;
        return this;
    }

    @Override
    public int compareTo(BinaryTreeNode<T> o) {
        return this.value.compareTo(o.value);
    }
}
