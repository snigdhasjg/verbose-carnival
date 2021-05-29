package com.joe.tree;

import com.joe.tree.node.TreeNode;
import com.joe.tree.util.TreePrinter;
import lombok.Getter;

import java.util.Optional;

import static java.util.Objects.isNull;

@Getter
public class BinarySearchTree<T extends Comparable<T>> {
    private TreeNode<T> root;

    public BinarySearchTree<T> addNode(T value) {
        TreeNode<T> nodeToAdd = new TreeNode<>(value);
        if (isNull(root)) {
            root = nodeToAdd;
        } else {
            addNodeInOrder(root, nodeToAdd);
        }
        return this;
    }

    public T getInOrderSuccessor(T value) {
        return Optional.ofNullable(inOrderSuccessor(root, new TreeNode<>(value)))
                .map(TreeNode::getValue)
                .orElse(null);
    }

    @Override
    public String toString() {
        return TreePrinter.formatTree(root);
    }

    private TreeNode<T> inOrderSuccessor(TreeNode<T> currentNode, TreeNode<T> nodeToFind) {
        if (isNull(currentNode)) {
            return null;
        }
        if (currentNode.equals(nodeToFind)) {
            return findLeftMostNode(currentNode.getRight());
        } else {
            if (nodeToFind.compareTo(currentNode) < 0) {
                TreeNode<T> tempTreeNode = inOrderSuccessor(currentNode.getLeft(), nodeToFind);
                if (isNull(tempTreeNode)) {
                    return currentNode;
                }
                return tempTreeNode;
            } else {
                return inOrderSuccessor(currentNode.getRight(), nodeToFind);
            }
        }
    }

    private TreeNode<T> findLeftMostNode(TreeNode<T> currentNode) {
        if (isNull(currentNode) || isNull(currentNode.getLeft())) {
            return currentNode;
        }
        return findLeftMostNode(currentNode.getLeft());
    }

    private void addNodeInOrder(TreeNode<T> treeNode, TreeNode<T> nodeToAdd) {
        if (nodeToAdd.compareTo(treeNode) < 0) {
            if (isNull(treeNode.getLeft())) {
                treeNode.setLeft(nodeToAdd);
                return;
            }
            addNodeInOrder(treeNode.getLeft(), nodeToAdd);
        } else if (nodeToAdd.compareTo(treeNode) > 0) {
            if (isNull(treeNode.getRight())) {
                treeNode.setRight(nodeToAdd);
                return;
            }
            addNodeInOrder(treeNode.getRight(), nodeToAdd);
        }
    }
}
