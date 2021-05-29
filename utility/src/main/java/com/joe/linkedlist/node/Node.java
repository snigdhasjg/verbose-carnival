package com.joe.linkedlist.node;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Node<T> {
    private final T value;
    private Node<T> next;

    public Node<T> setNext(Node<T> next) {
        this.next = next;
        return this;
    }
}
