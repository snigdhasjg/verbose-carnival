package com.joe.example.tree;

import com.joe.tree.AVLTree;

import java.util.Scanner;

public class AVLTreeExample {
    public static void main(String[] args) {
        AVLTree<Integer> integerAVLTree = new AVLTree<>();
        // Seed some data
        integerAVLTree.add(43).add(18).add(22).add(9).add(21).add(6).add(8).add(20).add(63).add(50).add(62).add(51);

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Want to continue (y): ");
            String shouldContinue = sc.next();
            if ("y".equals(shouldContinue)) {
                System.out.print("Please provide number: ");
                integerAVLTree.add(sc.nextInt());
            } else {
                break;
            }
        }
    }
}
