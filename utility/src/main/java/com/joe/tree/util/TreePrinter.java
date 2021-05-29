package com.joe.tree.util;

import com.joe.tree.node.TreeNode;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static java.util.Objects.nonNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TreePrinter {

    public static String formatTree(TreeNode<?> rootNode) {
        StringBuilder buffer = new StringBuilder();
        print(rootNode, buffer, "", "");
        return buffer.toString();
    }

    private static void print(TreeNode<?> treeNode, StringBuilder buffer, String prefix, String childrenPrefix) {
        buffer.append(prefix);
        buffer.append(treeNode.getValue());
        buffer.append('\n');

        if (nonNull(treeNode.getLeft())) {
            if (nonNull(treeNode.getRight())) {
                print(treeNode.getRight(), buffer, childrenPrefix + "├── ", childrenPrefix + "│   ");
            }
            print(treeNode.getLeft(), buffer, childrenPrefix + "└── ", childrenPrefix + '\t');
        } else if (nonNull(treeNode.getRight())) {
            print(treeNode.getRight(), buffer, childrenPrefix + "└── ", childrenPrefix + '\t');
        }
    }
}
