package com.joe.datastructure;

import com.joe.linkedlist.DoublyLinkedList;

public interface Stack<T extends Comparable<T>> {
    boolean isEmpty();

    T peak();

    void push(T item);

    T pop();

    static <T extends Comparable<T>> Stack<T> defaultStack() {
        return new DoublyLinkedList<>();
    }
}
