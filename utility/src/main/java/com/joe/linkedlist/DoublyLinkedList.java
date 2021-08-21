package com.joe.linkedlist;

import com.joe.datastructure.Group;
import com.joe.datastructure.Queue;
import com.joe.datastructure.Stack;
import com.joe.linkedlist.node.DoublyLinkedNode;
import com.joe.linkedlist.util.NodePrinter;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Getter
@Slf4j
public class DoublyLinkedList<T extends Comparable<T>>
    implements Group<T, DoublyLinkedList<T>>, Queue<T>, Stack<T> {

    private DoublyLinkedNode<T> head;
    private DoublyLinkedNode<T> tail;

    @Override
    public boolean isEmpty() {
        return isNull(head);
    }

    @Override
    public T peak() {
        if (isNull(head)) {
            return null;
        }
        return head.getValue();
    }

    @Override
    public void push(T item) {
        addFirst(item);
    }

    @Override
    public T pop() {
        return removeFirst();
    }

    @Override
    public void enqueue(T item) {
        add(item);
    }

    @Override
    public T dequeue() {
        return removeFirst();
    }

    @Override
    public DoublyLinkedList<T> add(T value) {
        DoublyLinkedNode<T> node = new DoublyLinkedNode<>(value);
        if (isNull(head)) {
            head = node;
        } else {
            tail.setNext(node);
            node.setPrevious(tail);
        }
        tail = node;
        return this;
    }

    public DoublyLinkedList<T> add(DoublyLinkedList<T> doublyLinkedList) {
        if (isNull(head)) {
            head = doublyLinkedList.head;
            tail = doublyLinkedList.tail;
        } else if (nonNull(doublyLinkedList.head)) {
            tail.setNext(doublyLinkedList.head);
            doublyLinkedList.head.setPrevious(tail);
            tail = doublyLinkedList.tail;
        }
        doublyLinkedList.head = null;
        doublyLinkedList.tail = null;
        return this;
    }

    public DoublyLinkedList<T> addFirst(T value) {
        DoublyLinkedNode<T> node = new DoublyLinkedNode<>(value);
        if (isNull(head)) {
            tail = node;
        } else {
            node.setNext(head);
            head.setPrevious(node);
        }
        head = node;
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

    private T removeFirst() {
        if (isNull(head)) {
            return null;
        }

        T value = head.getValue();

        if (head.equals(tail)) {
            head = null;
            tail = null;
            return value;
        }

        head = head.getNext();
        head.setPrevious(null);
        return value;
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
