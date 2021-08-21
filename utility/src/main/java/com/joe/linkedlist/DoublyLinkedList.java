package com.joe.linkedlist;

import com.joe.datastructure.Group;
import com.joe.linkedlist.node.DoublyLinkedNode;
import com.joe.linkedlist.util.NodePrinter;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Getter
@Slf4j
public class DoublyLinkedList<T extends Comparable<T>> implements Group<T, DoublyLinkedList<T>> {
    private DoublyLinkedNode<T> head;
    private DoublyLinkedNode<T> tail;

    @Override
    public boolean isEmpty() {
        return isNull(head);
    }

    @Override
    public DoublyLinkedList<T> add(T value) {
        DoublyLinkedNode<T> node = new DoublyLinkedNode<>(value);
        if (isNull(head)) {
            head = node;
            tail = node;
            return this;
        }
        tail.setNext(node);
        node.setPrevious(tail);
        tail = node;
        return this;
    }

    @Override
    public void remove(T value) {
        if (isNull(head)) {
            return;
        }
        DoublyLinkedNode<T> nodeToDelete = searchNode(head, tail, new DoublyLinkedNode<>(value));
        if (nonNull(nodeToDelete)) {
            if (head.equals(nodeToDelete) || tail.equals(nodeToDelete)) {
                if (head.equals(nodeToDelete)) {
                    head = head.getNext();
                    head.setPrevious(null);
                }
                if (tail.equals(nodeToDelete)) {
                    tail = tail.getPrevious();
                    tail.setNext(null);
                }
            } else {
                DoublyLinkedNode<T> next = nodeToDelete.getNext();
                DoublyLinkedNode<T> previous = nodeToDelete.getPrevious();
                next.setPrevious(previous);
                previous.setNext(next);
            }
        } else {
            log.warn("Node not present in the list");
        }
    }

    @Override
    public String toString() {
        return NodePrinter.formatNode(head);
    }

    private DoublyLinkedNode<T> searchNode(DoublyLinkedNode<T> left, DoublyLinkedNode<T> right, DoublyLinkedNode<T> nodeToFind) {
        if (left.equals(nodeToFind)) {
            return left;
        }
        if (right.equals(nodeToFind)) {
            return right;
        }
        if (left.equals(right) || left.getNext().equals(right)) {
            return null;
        }
        return searchNode(left.getNext(), right.getPrevious(), nodeToFind);
    }

}
