package com.joe.linkedlist;

import com.joe.datastructure.Group;
import com.joe.linkedlist.node.LinkedNode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicBoolean;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Slf4j
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
        AtomicBoolean isNodePresent = new AtomicBoolean(false);
        removeNode(nodeToDelete, head.getNext(), isNodePresent);
        if (!isNodePresent.get()) {
            log.warn("Node not present in the list");
        }
    }

    private LinkedNode<T> removeNode(LinkedNode<T> nodeToDelete, LinkedNode<T> temp, AtomicBoolean isNodePresent) {
        if (isNull(temp)) {
            return null;
        }
        if (temp.equals(nodeToDelete)) {
            return temp;
        }
        LinkedNode<T> node = removeNode(nodeToDelete, temp.getNext(), isNodePresent);
        if (nonNull(node)) {
            temp.setNext(node.getNext());
            isNodePresent.set(true);
        }
        return null;
    }
}
