package org.src.challenges;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * A utility class for various binary tree traversal problems.
 * This class includes methods for level-order, in-order, pre-order,
 * and post-order traversals of a binary tree.
 */
public class TreeProblems {

    /**
     * Performs a level-order (breadth-first) traversal of the binary tree.
     *
     * @param root the root node of the binary tree
     */
    static void levelOrder(Node root) {
        System.out.println("\n Level-Order: ");
        Queue<Node> viewQueue = new LinkedList<>();
        if (root != null) {
            viewQueue.add(root);
        }
        while (!viewQueue.isEmpty()) {
            int treeSize = viewQueue.size();
            for (int i = 0; i < treeSize; i++) {
                Node current = viewQueue.poll();
                if (current.left != null) {
                    viewQueue.add(current.left);
                }
                if (current.right != null) {
                    viewQueue.add(current.right);
                }
                System.out.println(current.data);
            }
        }
    }

    static void levelOrderZigZag(Node root) {
        System.out.println("\n Level-Order Zig-Zag: ");
        Deque<Node> viewQueue = new LinkedList<>();
        if (root != null) {
            viewQueue.add(root);
        }
        boolean zigZag = false;
        while (!viewQueue.isEmpty()) {
            int treeSize = viewQueue.size();
            for (int i = 0; i < treeSize; i++) {
                Node current = viewQueue.poll();
                if (zigZag) {
                    if (current.right != null) {
                        viewQueue.add(current.right);
                    }
                    if (current.left != null) {
                        viewQueue.add(current.left);
                    }
                } else {
                    if (current.left != null) {
                        viewQueue.add(current.left);
                    }
                    if (current.right != null) {
                        viewQueue.add(current.right);
                    }
                }

                System.out.print(current.data + " ");
            }
            zigZag = !zigZag;
        }
    }

    /**
     * Performs an in-order (left, root, right) traversal of the binary tree.
     *
     * @param root the root node of the binary tree
     */
    static void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.println(root.data);
            inOrderTraversal(root.right);
        }
    }

    /**
     * Performs a pre-order (root, left, right) traversal of the binary tree.
     *
     * @param root the root node of the binary tree
     */
    static void preOrderTraversal(Node root) {
        if (root != null) {
            System.out.println(root.data);
            inOrderTraversal(root.left);   // <-- Likely a bug: should be preOrderTraversal
            inOrderTraversal(root.right);  // <-- Likely a bug: should be preOrderTraversal
        }
    }

    /**
     * Performs a post-order (left, right, root) traversal of the binary tree.
     *
     * @param root the root node of the binary tree
     */
    static void postOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);   // <-- Likely a bug: should be postOrderTraversal
            inOrderTraversal(root.right);  // <-- Likely a bug: should be postOrderTraversal
            System.out.println(root.data);
        }
    }

    /**
     * Main method to demonstrate the various binary tree traversals.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Node root = new Node(100,
                new Node(23,
                        new Node(1, null, null),
                        new Node(10,
                                new Node(556, null, null),
                                null
                        )
                ),
                new Node(66,
                        null,
                        new Node(99, null, null
                        )
                )
        );

        levelOrder(root);
        levelOrderZigZag(root);
        System.out.println("\n Pre-Order: ");
        preOrderTraversal(root);
        System.out.println("\n Post-Order: ");
        postOrderTraversal(root);
        System.out.println("\n In-Order: ");
        inOrderTraversal(root);
    }

    /**
     * A class representing a node in the binary tree.
     */
    static class Node {
        Integer data;
        Node left;
        Node right;

        /**
         * Constructs a binary tree node with given data and children.
         *
         * @param data  the value of the node
         * @param left  the left child node
         * @param right the right child node
         */
        public Node(Integer data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
