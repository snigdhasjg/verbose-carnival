package com.joe.linkedlist;

import com.joe.datastructure.Group;
import com.joe.linkedlist.node.LinkedNode;
import lombok.Getter;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class LinkedList<T extends Comparable<T>> implements Group<T, LinkedList<T>> {
    @Getter
    private LinkedNode<T> head;
    private LinkedNode<T> tail;

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public LinkedList<T> add(T value) {
        LinkedNode<T> node = new LinkedNode<>(value);
        if (isNull(head)) {
            head = node;
            tail = node;
            return this;
        }
        tail.setNext(node);
        tail = node;
        return this;
    }

    @Override
    public void remove(T value) {
        if (isNull(head)) {
            return;
        }
        LinkedNode<T> nodeToDelete = new LinkedNode<>(value);
        if (head.equals(nodeToDelete)) {
            head = head.getNext();
            return;
        }
        removeNode(nodeToDelete, head.getNext());
    }

    private LinkedNode<T> removeNode(LinkedNode<T> nodeToDelete, LinkedNode<T> temp) {
        if (isNull(temp)) {
            return null;
        }
        if (temp.equals(nodeToDelete)) {
            return temp;
        }
        LinkedNode<T> node = removeNode(nodeToDelete, temp.getNext());
        if (nonNull(node)) {
            temp.setNext(node.getNext());
        }
        return null;
    }
}
