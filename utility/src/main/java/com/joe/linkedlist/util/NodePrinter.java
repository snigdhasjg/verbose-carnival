package com.joe.linkedlist.util;

import com.joe.linkedlist.node.DoublyLinkedNode;
import com.joe.linkedlist.node.LinkedNode;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NodePrinter {
    public static String formatNode(DoublyLinkedNode<?> headNode) {
        StringBuilder buffer = new StringBuilder();
        buffer.append("head->");
        if (nonNull(headNode)) {
            print(headNode, buffer);
        }
        buffer.append("<-Tail");
        return buffer.toString();
    }

    public static String formatNode(LinkedNode<?> headNode) {
        StringBuilder buffer = new StringBuilder();
        buffer.append("head->");
        if (nonNull(headNode)) {
            print(headNode, buffer);
        }
        return buffer.toString();
    }

    private static void print(DoublyLinkedNode<?> currentNode, StringBuilder buffer) {
        buffer.append(currentNode.getValue());
        if (isNull(currentNode.getNext())) {
            return;
        }
        buffer.append("<->");
        print(currentNode.getNext(), buffer);
    }

    private static void print(LinkedNode<?> currentNode, StringBuilder buffer) {
        buffer.append(currentNode.getValue());
        if (isNull(currentNode.getNext())) {
            return;
        }
        buffer.append("->");
        print(currentNode.getNext(), buffer);
    }
}
