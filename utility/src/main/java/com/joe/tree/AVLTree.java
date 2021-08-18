package com.joe.tree;

import com.joe.tree.node.AVLTreeNode;
import lombok.Getter;

import static java.util.Objects.isNull;

@Getter
public class AVLTree<T extends Comparable<T>> {
    private AVLTreeNode<T> root;

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
}
