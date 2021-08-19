package com.joe.tree.node;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import static java.util.Objects.isNull;

@Getter
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class AVLTreeNode<T extends Comparable<T>> implements Comparable<AVLTreeNode<T>>, IBinaryTreeNode<T> {
    @Setter
    @NonNull
    private T value;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private AVLTreeNode<T> left;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private AVLTreeNode<T> right;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private int height = 1;

    public AVLTreeNode<T> setLeft(AVLTreeNode<T> left) {
        this.left = left;
        return this;
    }

    public AVLTreeNode<T> setRight(AVLTreeNode<T> right) {
        this.right = right;
        return this;
    }

    public void updateHeight() {
        this.height = Math.max(height(left), height(right)) + 1;
    }

    public int getBalance() {
        return height(left) - height(right);
    }

    @Override
    public int compareTo(AVLTreeNode<T> o) {
        return this.value.compareTo(o.value);
    }

    private static int height(AVLTreeNode<?> node) {
        if (isNull(node)) {
            return 0;
        }
        return node.getHeight();
    }
}
