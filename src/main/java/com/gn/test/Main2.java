package com.gn.test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main2 {

        public static void main(String[] args) {
            Node node = new Node(1);
            node.left = new Node(2);
            node.right = new Node(3);

            print(node);
        }

        static class Node {
            private Node left;
            private Node right;
            private int value;

            public Node(int value) {
                this.value = value;
            }
        }

        private static void print(Node node) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(node);

            while(queue.size() > 0) {
                Node n = queue.poll();
                System.out.println(n.value);
                if (n.left != null)
                    queue.add(n.left);
                if (n.right != null)
                    queue.add(n.right);
            }
        }

}
