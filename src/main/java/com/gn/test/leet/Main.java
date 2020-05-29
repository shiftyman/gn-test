package com.gn.test.leet;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Node node = new Node('a');
        node.next = new Node('b');
        node.next.next = new Node('b');
        node.next.next.next = new Node('a');
        System.out.println(isSymmetry(node));
    }

    public static class Node {
        public char c;
        public Node next;

        public Node(char c) {
            this.c = c;
        }
    }

    public static boolean isSymmetry(Node node) {
        if (node == null || node.next == null) {
            return true;
        }

        Stack<Node> stack = new Stack<>();

        // calculate count
        int count = 0;
        Node first = node;
        while (first != null) {
            count++;
            first = first.next;
        }

        // push first half
        first = node;
        for (int i = 0; i < count/2; i++) {
            stack.push(first);
            first = first.next;
        }

        if (count % 2 != 0) {
            first = first.next; // skip
        }

        // judge
        for (int i = 0; i < count / 2; i++, first = first.next) {
            if (stack.pop().c != first.c)
                return false;
        }

        return true;
    }
}
