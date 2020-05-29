package com.gn.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Main10 {

    private static Node root;
    private static HashSet<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        InputStreamReader input1=new InputStreamReader(System.in);
        BufferedReader in=new BufferedReader(input1);
        String str1=in.readLine();
        String str2=in.readLine();

        int number = Integer.valueOf(str1);
        String[] s = str2.split(" ");
        for (int i = 0; i < number; i++) {
            addNode2(root, Integer.valueOf(s[i]));
        }

        if (number > 0) {
            set.clear();
            preOrder(root);
            System.out.println();
            set.clear();
            inOrder(root);
            System.out.println();
            set.clear();
            postOrder(root);
            System.out.println();

        }
    }

    static class Node {
        Node left, right;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void addNode2(Node node, int value) {
        if (node == null) {
            root = new Node(value);
            return;
        }

        if (value < node.value) {
            if (node.left == null)
                node.left = new Node(value);
            else
                addNode2(node.left, value);
        } else {
            if (node.right == null)
                node.right = new Node(value);
            else
                addNode2(node.right, value);
        }
    }

    public static void addNode(int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }

        Node cur = root;
        while (true) {
            if (value >= cur.value) {
                if (cur.right == null) {
                    cur.right = new Node(value);
                    return;
                }
                cur = cur.right;
            } else {
                if (cur.left == null) {
                    cur.left = new Node(value);
                    return;
                }
                cur = cur.left;
            }
        }
    }

    public static void preOrder(Node node) {
//        if (node == null) {
//            return;
//        }
//
//        if (!set.contains(node.value)) {
//            System.out.print(node.value + " ");
//            set.add(node.value);
//        }
//        preOrder(node.left);
//        preOrder(node.right);

        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while (curr != null || !stack.isEmpty()) {
            // 左子树
            while (curr != null) {
                System.out.print(curr.value + " ");
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            curr = curr.right;
        }
    }

    public static void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);

        if (!set.contains(node.value)) {
            System.out.print(node.value + " ");
            set.add(node.value);
        }

        inOrder(node.right);

//        Stack<Node> stack = new Stack<>();
//        Node curr = root;
//        while (curr != null || !stack.isEmpty()) {
//            // 左子树
//            while (curr != null) {
//                stack.push(curr);
//                curr = curr.left;
//            }
//
//            curr = stack.pop();
//            System.out.print(curr.value + " ");
//            curr = curr.right;
//        }
    }

    public static void postOrder(Node node1) {
//        if (node == null) {
//            return;
//        }
//
//        postOrder(node.left);
//        postOrder(node.right);
//
//        if (!set.contains(node.value)) {
//            System.out.print(node.value + " ");
//            set.add(node.value);
//        }

        Stack<Node> stack = new Stack<>();
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            ((LinkedList<Integer>) res).addFirst(node.value);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }

        System.out.println(res);
    }
}
