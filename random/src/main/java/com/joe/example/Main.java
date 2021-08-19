package com.joe.example;

import com.joe.tree.AVLTree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AVLTree<Integer> integerAVLTree = new AVLTree<>();
        integerAVLTree.add(43).add(18).add(22).add(9).add(21).add(6).add(8).add(20).add(63).add(50).add(62).add(51);
        System.out.println(integerAVLTree);

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Please provide number: ");
            int numberToAdd = sc.nextInt();
            if (numberToAdd == 0) {
                break;
            }
            integerAVLTree.add(numberToAdd);
            System.out.println(integerAVLTree);
        }
    }
}
