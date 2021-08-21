package com.joe.tree.rotator;

import com.joe.tree.node.AVLTreeNode;

public class AVLTreeRotator<T extends Comparable<T>> extends TreeRotator<T, AVLTreeNode<T>> {

    public AVLTreeNode<T> rotateIfPossible(AVLTreeNode<T> avlTreeNode, AVLTreeNode<T> respectiveTo) {
        int balance = avlTreeNode.getBalance();

        if (balance < -1) {
            if (respectiveTo.compareTo(avlTreeNode.getRight()) > 0) {
                return leftRotation(avlTreeNode);
            }
            return rightLeftRotation(avlTreeNode);
        } else if (balance > 1) {
            if (respectiveTo.compareTo(avlTreeNode.getLeft()) < 0) {
                return rightRotation(avlTreeNode);
            }
            return leftRightRotation(avlTreeNode);
        }
        return avlTreeNode;
    }

    @Override
    protected void postRotation(AVLTreeNode<T> grandParent, AVLTreeNode<T> parent) {
        grandParent.updateHeight();
        parent.updateHeight();
    }
}
