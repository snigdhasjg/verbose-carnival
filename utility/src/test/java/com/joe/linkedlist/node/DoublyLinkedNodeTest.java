package com.joe.linkedlist.node;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DoublyLinkedNodeTest {
    @Test
    void shouldConstructLink() {
        DoublyLinkedNode<Integer> doublyLinkedNode = new DoublyLinkedNode<>(1)
            .setNext(new DoublyLinkedNode<>(2))
            .setPrevious(new DoublyLinkedNode<>(3));

        assertEquals(1, doublyLinkedNode.getValue());
        DoublyLinkedNode<Integer> next = doublyLinkedNode.getNext();
        assertEquals(2, next.getValue());
        DoublyLinkedNode<Integer> previous = doublyLinkedNode.getPrevious();
        assertEquals(3, previous.getValue());
    }

    @Test
    void shouldCompareWithEachOther() {
        assertEquals(-1, new DoublyLinkedNode<>(1).compareTo(new DoublyLinkedNode<>(4)));
    }
}
