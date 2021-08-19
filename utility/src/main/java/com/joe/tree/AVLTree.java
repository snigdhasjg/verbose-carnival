package com.joe.tree;

import com.joe.datastructure.Group;
import com.joe.tree.node.AVLTreeNode;
import com.joe.tree.util.TreePrinter;
import lombok.Getter;

import static java.util.Objects.isNull;

@Getter
public class AVLTree<T extends Comparable<T>> implements Group<T, AVLTree<T>> {
    private AVLTreeNode<T> root;

    @Override
    public boolean isEmpty() {
        return isNull(root);
    }

    @Override
    public AVLTree<T> add(T value) {
        root = addNodeInOrder(root, new AVLTreeNode<>(value));
        return this;
    }

    @Override
    public void remove(T value) {

    }

    @Override
    public String toString() {
        return TreePrinter.formatTree(root);
    }

    public void calculateHeight(AVLTreeNode<T> grandParent) {
        grandParent.updateHeight();
        root.updateHeight();
    }

    public AVLTreeNode<T> leftRotation(AVLTreeNode<T> grandParent) {
        /*
         4 -> grandParent            6
           \                       /   \
             6 -> parent    -->  4       8
               \
                 8
         */
        if (isNull(grandParent)) {
            return null;
        }
        AVLTreeNode<T> parent = grandParent.getRight();
        grandParent.setRight(parent.getLeft());
        parent.setLeft(grandParent);
        calculateHeight(grandParent);
        return parent;
    }

    public AVLTreeNode<T> rightRotation(AVLTreeNode<T> grandParent) {
        /*
                 8 -> grandParent         6
               /                        /   \
             6 -> parent         -->  4       8
           /
         4
         */
        if (isNull(grandParent)) {
            return null;
        }
        AVLTreeNode<T> parent = grandParent.getLeft();
        grandParent.setLeft(parent.getRight());
        parent.setRight(grandParent);
        calculateHeight(grandParent);
        return parent;
    }

    public AVLTreeNode<T> rightLeftRotation(AVLTreeNode<T> grandParent) {
        /*
         4                        4 => leftRotate        6
           \                        \                  /   \
             8 => rightRotate   -->   6          --> 4       8
           /                            \
         6                                8
         */
        if (isNull(grandParent)) {
            return null;
        }
        grandParent.setRight(rightRotation(grandParent.getRight()));
        return leftRotation(grandParent);
    }

    public AVLTreeNode<T> leftRightRotation(AVLTreeNode<T> grandParent) {
        /*
             8                      8 => rightRotate     6
           /                      /                    /   \
         4 => leftRotate   -->  6              -->   4       8
          \                   /
            6               4
         */
        if (isNull(grandParent)) {
            return null;
        }
        grandParent.setLeft(leftRotation(grandParent.getLeft()));
        return rightRotation(grandParent);
    }

    private AVLTreeNode<T> addNodeInOrder(AVLTreeNode<T> avlTreeNode, AVLTreeNode<T> nodeToAdd) {
        if (isNull(avlTreeNode)) {
            return nodeToAdd;
        }
        if (nodeToAdd.compareTo(avlTreeNode) < 0) {
            avlTreeNode.setLeft(addNodeInOrder(avlTreeNode.getLeft(), nodeToAdd));
        } else if (nodeToAdd.compareTo(avlTreeNode) > 0) {
            avlTreeNode.setRight(addNodeInOrder(avlTreeNode.getRight(), nodeToAdd));
        }

        avlTreeNode.updateHeight();
        int balance = avlTreeNode.getBalance();

        if (balance < -1) {
            if (nodeToAdd.compareTo(avlTreeNode.getRight()) > 0) {
                return leftRotation(avlTreeNode);
            }
            return rightLeftRotation(avlTreeNode);
        } else if (balance > 1) {
            if (nodeToAdd.compareTo(avlTreeNode.getLeft()) < 0) {
                return rightRotation(avlTreeNode);
            }
            return leftRightRotation(avlTreeNode);
        }

        return avlTreeNode;
    }
}
