package com.joe.linkedlist.node;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class LinkedNode<T extends Comparable<T>> implements Comparable<LinkedNode<T>> {
    private final T value;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private LinkedNode<T> next;

    public LinkedNode<T> setNext(LinkedNode<T> next) {
        this.next = next;
        return this;
    }

    @Override
    public int compareTo(LinkedNode<T> o) {
        return this.value.compareTo(o.value);
    }
}
