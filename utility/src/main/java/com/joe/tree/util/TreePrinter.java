package com.joe.tree.util;

import com.joe.tree.node.IBinaryTreeNode;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static java.util.Objects.nonNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TreePrinter {

    public static String formatTree(IBinaryTreeNode<?> rootNode) {
        StringBuilder buffer = new StringBuilder();
        print(rootNode, buffer, "", "");
        return buffer.toString();
    }

    private static void print(IBinaryTreeNode<?> binaryTreeNode, StringBuilder buffer, String prefix, String childrenPrefix) {
        buffer.append(prefix);
        buffer.append(binaryTreeNode);
        buffer.append('\n');

        if (nonNull(binaryTreeNode.getLeft())) {
            if (nonNull(binaryTreeNode.getRight())) {
                print(binaryTreeNode.getRight(), buffer, childrenPrefix + "├── ", childrenPrefix + "│   ");
            }
            print(binaryTreeNode.getLeft(), buffer, childrenPrefix + "└── ", childrenPrefix + '\t');
        } else if (nonNull(binaryTreeNode.getRight())) {
            print(binaryTreeNode.getRight(), buffer, childrenPrefix + "└── ", childrenPrefix + '\t');
        }
    }
}
