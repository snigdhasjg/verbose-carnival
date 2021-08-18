package com.joe.linkedlist.util;

import com.joe.linkedlist.DoublyLinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NodePrinterTest {
    @Test
    void shouldPrintLinkedListWithMultipleNode() {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.add(1).add(2).add(3);

        assertEquals("head->1<->2<->3<-Tail", NodePrinter.formatNode(doublyLinkedList.getHead()));
    }

    @Test
    void shouldPrintLinkedListWithOnlyOneNode() {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.add(1);

        assertEquals("head->1<-Tail", NodePrinter.formatNode(doublyLinkedList.getHead()));
    }

    @Test
    void shouldPrintLinkedListWithOnlyNoNode() {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();

        assertEquals("head-><-Tail", NodePrinter.formatNode(doublyLinkedList.getHead()));
    }
}
