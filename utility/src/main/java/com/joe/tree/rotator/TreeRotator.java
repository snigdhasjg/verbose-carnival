package com.joe.tree.rotator;

import com.joe.tree.node.IBinaryTreeNode;
import com.joe.tree.util.TreePrinter;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
public abstract class TreeRotator<T extends Comparable<T>, U extends IBinaryTreeNode<T, U>> {

    protected abstract void postRotation(U grandParent, U parent);

    protected U leftRotation(U grandParent) {
        /*
         4 -> grandParent            6
           \                       /   \
             6 -> parent    -->  4       8
               \
                 8
         */
        if (Objects.isNull(grandParent)) {
            return null;
        }
        log.info("Pre Left Rotate: \n{}", TreePrinter.formatTree(grandParent));
        U parent = grandParent.getRight();
        grandParent.setRight(parent.getLeft());
        parent.setLeft(grandParent);

        postRotation(grandParent, parent);

        log.info("Post Left Rotate: \n{}", TreePrinter.formatTree(parent));
        return parent;
    }

    protected U rightRotation(U grandParent) {
        /*
                 8 -> grandParent         6
               /                        /   \
             6 -> parent         -->  4       8
           /
         4
         */
        if (Objects.isNull(grandParent)) {
            return null;
        }
        log.info("Pre Right Rotate: \n{}", TreePrinter.formatTree(grandParent));
        U parent = grandParent.getLeft();
        grandParent.setLeft(parent.getRight());
        parent.setRight(grandParent);

        postRotation(grandParent, parent);

        log.info("Post Right Rotate: \n{}", TreePrinter.formatTree(parent));
        return parent;
    }

    protected U rightLeftRotation(U grandParent) {
        /*
         4                        4 => leftRotate        6
           \                        \                  /   \
             8 => rightRotate   -->   6          --> 4       8
           /                            \
         6                                8
         */
        if (Objects.isNull(grandParent)) {
            return null;
        }
        log.info("Pre Right Left Rotation");
        grandParent.setRight(rightRotation(grandParent.getRight()));
        U treeNode = leftRotation(grandParent);
        log.info("Post Right Left Rotation");
        return treeNode;
    }

    protected U leftRightRotation(U grandParent) {
        /*
             8                      8 => rightRotate     6
           /                      /                    /   \
         4 => leftRotate   -->  6              -->   4       8
          \                   /
            6               4
         */
        if (Objects.isNull(grandParent)) {
            return null;
        }
        log.info("Pre Left Right Rotation");
        grandParent.setLeft(leftRotation(grandParent.getLeft()));
        U treeNode = rightRotation(grandParent);
        log.info("Post Left Right Rotation");
        return treeNode;
    }
}
