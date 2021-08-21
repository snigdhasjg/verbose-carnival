package com.joe.datastructure;

import com.joe.linkedlist.DoublyLinkedList;

public interface Queue<T extends Comparable<T>> {
    boolean isEmpty();

    T peak();

    void enqueue(T item);

    T dequeue();

    static <T extends Comparable<T>> Queue<T> defaultQueue() {
        return new DoublyLinkedList<>();
    }
}
