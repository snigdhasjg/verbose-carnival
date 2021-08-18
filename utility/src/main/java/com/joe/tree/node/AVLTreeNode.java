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
public class AVLTreeNode<T extends Comparable<T>> implements Comparable<AVLTreeNode<T>> {
    @Setter
    @NonNull
    private T value;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private AVLTreeNode<T> left;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private AVLTreeNode<T> right;

    public AVLTreeNode<T> setLeft(AVLTreeNode<T> left) {
        this.left = left;
        return this;
    }

    public AVLTreeNode<T> setRight(AVLTreeNode<T> right) {
        this.right = right;
        return this;
    }

    @Override
    public int compareTo(AVLTreeNode<T> o) {
        return 0;
    }
}
