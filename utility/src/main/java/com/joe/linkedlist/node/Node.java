package com.joe.linkedlist.node;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class Node<T> {
    private final T value;
    @EqualsAndHashCode.Exclude @ToString.Exclude
    private Node<T> next;

    public Node<T> setNext(Node<T> next) {
        this.next = next;
        return this;
    }
}
