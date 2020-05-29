package com.gn.test;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Inorder {

    public static class Node {
        int value;
        Node left, right;
    }

    public List<Integer> inorderTraversal(Node root) {
        List<Integer> res = new LinkedList<>();
        Stack<Node> stack = new Stack<>();

        Node curr = root;
        while (curr != null || !stack.isEmpty()) {
            // 左子树
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            res.add(curr.value);
            curr = curr.right;
        }

        return res;
    }

    public List<Integer> preorderTraversal(Node root) {
        List<Integer> res = new LinkedList<>();
        Stack<Node> stack = new Stack<>();

        Node curr = root;
        while (curr != null || !stack.isEmpty()) {
            // 左子树
            while (curr != null) {
                res.add(curr.value);
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            curr = curr.right;
        }

        return res;
    }

    public List<Integer> postorderTraversal(Node root) {
        Stack<Node> stack = new Stack<>();
        LinkedList<Integer> res = new LinkedList<>();

        if (root == null) {
            return res;
        }

        Node curr = root;
        stack.push(curr);
        while (!stack.isEmpty()) {
            curr = stack.pop();
            res.addFirst(curr.value);
            if (curr.left != null) {
                stack.push(curr.left);
            }
            if (curr.right != null) {
                stack.push(curr.right);
            }
        }

        return res;
    }

}
