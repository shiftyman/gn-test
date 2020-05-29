package com.gn.test.leet;

public class RevertLink {

    public static void main(String[] args) {
        Node n = new Node('c');
        n.next = new Node('c');
//        n.next.next = new Node('a');

        System.out.println(isSymmetry(n));
    }

    public static class Node {
        public char c;
        public Node next;

        public Node(char c) {
            this.c = c;
        }
    }

    public static boolean isSymmetry(Node head) {
        if (head == null || head.next == null)
            return true;

        // calculate node count
        int count = 0;
        Node pointer = head;
        while (pointer != null) {
            count++;
            pointer = pointer.next;
        }

        // break the link
        Node left = head, right = head.next;
        for (int i = 1; i < count/2; i++) {
            left = left.next;
            right = right.next;
        }
        left.next = null;

        // revert left link
        Node first = head, second = first.next, third;
        first.next = null;
        while (second != null) {
            third = second.next;
            second.next = first;
            first = second;
            second = third;
        }

        // judge
        if (count % 2 != 0) {
            right = right.next;
        }
        while (left!=null) {
            if (left.c != right.c)
                return false;
            left = left.next;
            right = right.next;
        }

        return true;
    }
}
