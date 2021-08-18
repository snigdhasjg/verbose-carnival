package com.joe.linkedlist.node;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
        TestCompare object1 = mock(TestCompare.class);
        TestCompare object2 = mock(TestCompare.class);
        when(object1.compareTo(object2)).thenReturn(7);

        assertEquals(7, new DoublyLinkedNode<>(object1).compareTo(new DoublyLinkedNode<>(object2)));
    }

    private static class TestCompare implements Comparable<TestCompare> {
        @Override
        public int compareTo(TestCompare o) {
            return 0;
        }
    }
}
