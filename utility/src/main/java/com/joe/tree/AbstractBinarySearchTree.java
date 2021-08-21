package com.joe.tree;

import com.joe.datastructure.Group;
import com.joe.tree.node.BinaryTreeNode;
import com.joe.tree.node.IBinaryTreeNode;
import com.joe.tree.util.TreePrinter;
import lombok.Getter;

import java.util.Optional;

import static java.util.Objects.isNull;

@Getter
public abstract class AbstractBinarySearchTree<
    T extends Comparable<T>, // Object
    U extends IBinaryTreeNode<T, U>, // Node
    V extends AbstractBinarySearchTree<T, U, V>> // Tree
    implements Group<T, V> {

    protected U root;

    @Override
    public boolean isEmpty() {
        return isNull(root);
    }

    @Override
    @SuppressWarnings("unchecked")
    public V add(T value) {
        root = addNodeInOrder(root, newInstance(value));
        return (V) this;
    }

    @Override
    public void remove(T value) {
        root = deleteNodeInOrder(root, newInstance(value));
    }

    public T getInOrderSuccessor(T value) {
        return Optional.ofNullable(inOrderSuccessor(root, newInstance(value)))
                       .map(IBinaryTreeNode::getValue)
                       .orElse(null);
    }

    @Override
    public String toString() {
        return TreePrinter.formatTree(root);
    }

    protected abstract U newInstance(T value);

    protected abstract U postAdd(U currentNode, U nodeToAdd);

    private U deleteNodeInOrder(U currentNode, U data) {
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
                U minValueNode = findLeftMostNode(currentNode.getRight());
                currentNode.setValue(minValueNode.getValue());
                currentNode.setRight(deleteNodeInOrder(currentNode.getRight(), minValueNode));
            }
        }

        return currentNode;
    }

    private U inOrderSuccessor(U currentNode, U nodeToFind) {
        if (isNull(currentNode)) {
            return null;
        }
        if (currentNode.equals(nodeToFind)) {
            return findLeftMostNode(currentNode.getRight());
        } else {
            if (nodeToFind.compareTo(currentNode) < 0) {
                U tempBinaryTreeNode = inOrderSuccessor(currentNode.getLeft(), nodeToFind);
                if (isNull(tempBinaryTreeNode)) {
                    return currentNode;
                }
                return tempBinaryTreeNode;
            } else {
                return inOrderSuccessor(currentNode.getRight(), nodeToFind);
            }
        }
    }

    private U findLeftMostNode(U currentNode) {
        if (isNull(currentNode) || isNull(currentNode.getLeft())) {
            return currentNode;
        }
        return findLeftMostNode(currentNode.getLeft());
    }

    private U addNodeInOrder(U binaryTreeNode, U nodeToAdd) {
        if (isNull(binaryTreeNode)) {
            return nodeToAdd;
        }
        if (nodeToAdd.compareTo(binaryTreeNode) < 0) {
            binaryTreeNode.setLeft(addNodeInOrder(binaryTreeNode.getLeft(), nodeToAdd));
        } else if (nodeToAdd.compareTo(binaryTreeNode) > 0) {
            binaryTreeNode.setRight(addNodeInOrder(binaryTreeNode.getRight(), nodeToAdd));
        }
        return postAdd(binaryTreeNode, nodeToAdd);
    }
}
