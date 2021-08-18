package com.joe.linkedlist.node;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class DoublyLinkedNode<T extends Comparable<T>> implements Comparable<DoublyLinkedNode<T>> {
    private final T value;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private DoublyLinkedNode<T> previous;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private DoublyLinkedNode<T> next;

    public DoublyLinkedNode<T> setNext(DoublyLinkedNode<T> next) {
        this.next = next;
        return this;
    }

    public DoublyLinkedNode<T> setPrevious(DoublyLinkedNode<T> previous) {
        this.previous = previous;
        return this;
    }

    @Override
    public int compareTo(DoublyLinkedNode<T> o) {
        return this.value.compareTo(o.value);
    }
}
