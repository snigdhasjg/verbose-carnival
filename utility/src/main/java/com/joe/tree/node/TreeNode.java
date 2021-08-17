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
public class TreeNode<T extends Comparable<T>> implements Comparable<TreeNode<T>> {
    @Setter
    private @NonNull T value;
    private @EqualsAndHashCode.Exclude @ToString.Exclude TreeNode<T> left;
    private @EqualsAndHashCode.Exclude @ToString.Exclude TreeNode<T> right;

    public TreeNode<T> setLeft(TreeNode<T> left) {
        this.left = left;
        return this;
    }

    public TreeNode<T> setRight(TreeNode<T> right) {
        this.right = right;
        return this;
    }

    @Override
    public int compareTo(TreeNode<T> o) {
        return this.value.compareTo(o.value);
    }
}