package com.joe.tree;

import com.joe.datastructure.Group;
import com.joe.tree.node.BinaryTreeNode;
import com.joe.tree.util.TreePrinter;
import lombok.Getter;

import java.util.Optional;

import static java.util.Objects.isNull;

@Getter
public class BinarySearchTree<T extends Comparable<T>> implements Group<T, BinarySearchTree<T>> {
    private BinaryTreeNode<T> root;

    @Override
    public boolean isEmpty() {
        return isNull(root);
    }

    @Override
    public BinarySearchTree<T> add(T value) {
        BinaryTreeNode<T> nodeToAdd = new BinaryTreeNode<>(value);
        if (isNull(root)) {
            root = nodeToAdd;
        } else {
            addNodeInOrder(root, nodeToAdd);
        }
        return this;
    }

    @Override
    public void remove(T value) {
        root = deleteNodeInOrder(root, new BinaryTreeNode<>(value));
    }

    public T getInOrderSuccessor(T value) {
        return Optional.ofNullable(inOrderSuccessor(root, new BinaryTreeNode<>(value)))
                       .map(BinaryTreeNode::getValue)
                       .orElse(null);
    }

    @Override
    public String toString() {
        return TreePrinter.formatTree(root);
    }

    private BinaryTreeNode<T> deleteNodeInOrder(BinaryTreeNode<T> currentNode, BinaryTreeNode<T> data) {
        if (isNull(currentNode)) {
            return null;
        }

        if (data.compareTo(currentNode) < 0) {
            currentNode.setLeft(deleteNodeInOrder(currentNode.getLeft(), data));
        } else if (data.compareTo(currentNode) > 0) {
            currentNode.setRight(deleteNodeInOrder(currentNode.getRight(), data));
        } else {
            if (isNull(currentNode.getLeft()) && isNull(currentNode.getRight())) {
                return null;
            } else if (isNull(currentNode.getLeft())) {
                return currentNode.getRight();
            } else if (isNull(currentNode.getRight())) {
                return currentNode.getLeft();
            } else {
                T minValue = findLeftMostNode(currentNode.getRight()).getValue();
                currentNode.setValue(minValue);
                currentNode.setRight(deleteNodeInOrder(currentNode.getRight(), new BinaryTreeNode<>(minValue)));
            }
        }

        return currentNode;
    }

    private BinaryTreeNode<T> inOrderSuccessor(BinaryTreeNode<T> currentNode, BinaryTreeNode<T> nodeToFind) {
        if (isNull(currentNode)) {
            return null;
        }
        if (currentNode.equals(nodeToFind)) {
            return findLeftMostNode(currentNode.getRight());
        } else {
            if (nodeToFind.compareTo(currentNode) < 0) {
                BinaryTreeNode<T> tempBinaryTreeNode = inOrderSuccessor(currentNode.getLeft(), nodeToFind);
                if (isNull(tempBinaryTreeNode)) {
                    return currentNode;
                }
                return tempBinaryTreeNode;
            } else {
                return inOrderSuccessor(currentNode.getRight(), nodeToFind);
            }
        }
    }

    private BinaryTreeNode<T> findLeftMostNode(BinaryTreeNode<T> currentNode) {
        if (isNull(currentNode) || isNull(currentNode.getLeft())) {
            return currentNode;
        }
        return findLeftMostNode(currentNode.getLeft());
    }

    private void addNodeInOrder(BinaryTreeNode<T> binaryTreeNode, BinaryTreeNode<T> nodeToAdd) {
        if (nodeToAdd.compareTo(binaryTreeNode) < 0) {
            if (isNull(binaryTreeNode.getLeft())) {
                binaryTreeNode.setLeft(nodeToAdd);
                return;
            }
            addNodeInOrder(binaryTreeNode.getLeft(), nodeToAdd);
        } else if (nodeToAdd.compareTo(binaryTreeNode) > 0) {
            if (isNull(binaryTreeNode.getRight())) {
                binaryTreeNode.setRight(nodeToAdd);
                return;
            }
            addNodeInOrder(binaryTreeNode.getRight(), nodeToAdd);
        }
    }
}
