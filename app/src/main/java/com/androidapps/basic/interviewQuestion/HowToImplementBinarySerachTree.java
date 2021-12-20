package com.androidapps.basic.interviewQuestion;

import java.util.Stack;

public class HowToImplementBinarySerachTree {

    /*A binary search tree or BST is a popular data structure that is used to keep elements in order.
    A binary search tree is a binary tree where the value of a left child is less than or equal to the parent node and the value of the right child is greater than or equal to the parent node.
    Since its a binary tree, it can only have 0, 1, or two children. What makes a binary search tree special is its ability to reduce the time complexity of fundamental operations like add, remove, and search, also known as insert, delete and find.
    In a BST, all these operations (insert, remove, and find) can be performed in O(log(n)) time.

    Read more: https://javarevisited.blogspot.com/2015/10/how-to-implement-binary-search-tree-in-java-example.html#ixzz73pZNQGeU*/

    /*In this implementation, I have created a Node class, which is similar to our linked list node class, which we created when I have shown you how to implement linked list in Java. It has a data element, an integer and a Node reference to point to another node in the binary tree.

I have also created four basic functions, as shown below:
 getRoot(), returns the root of binary tree
 isEmpty(), to check if binary search tree is empty or not
 size(), to find the total number of nodes in a BST
 clear(), to clear the BST


Read more: https://javarevisited.blogspot.com/2015/10/how-to-implement-binary-search-tree-in-java-example.html#ixzz73pZsZAet*/


        //Represent a node of binary tree
        public static class Node {
            int data;
            Node left;
            Node right;

            public Node(int data) {
                //Assign data to the new node, set left and right children to null
                this.data = data;
                this.left = null;
                this.right = null;
            }
        }

        //Represent the root of binary tree
        public Node root;

        public HowToImplementBinarySerachTree() {
            root = null;
        }

        //insert() will add new node to the binary search tree
        public void insert(int data) {
            //Create a new node
            Node newNode = new Node(data);

            //Check whether tree is empty
            if (root == null) {
                root = newNode;
                return;
            } else {
                //current node point to root of the tree
                Node current = root, parent = null;

                while (true) {
                    //parent keep track of the parent node of current node.
                    parent = current;

                    //If data is less than current's data, node will be inserted to the left of tree
                    if (data < current.data) {
                        current = current.left;
                        if (current == null) {
                            parent.left = newNode;
                            return;
                        }
                    }
                    //If data is greater than current's data, node will be inserted to the right of tree
                    else {
                        current = current.right;
                        if (current == null) {
                            parent.right = newNode;
                            return;
                        }
                    }
                }
            }
        }

        //minNode() will find out the minimum node
        public Node minNode(Node root) {
            if (root.left != null)
                return minNode(root.left);
            else
                return root;
        }

        //deleteNode() will delete the given node from the binary search tree
        public Node deleteNode(Node node, int value) {
            if (node == null) {
                return null;
            }
            else {
                //value is less than node's data then, search the value in left subtree
                if (value < node.data)
                    node.left = deleteNode(node.left, value);

                    //value is greater than node's data then, search the value in right subtree
                else if (value > node.data)
                    node.right = deleteNode(node.right, value);

                    //If value is equal to node's data that is, we have found the node to be deleted
                else {
                    //If node to be deleted has no child then, set the node to null
                    if (node.left == null && node.right == null)
                        node = null;

                        //If node to be deleted has only one right child
                    else if (node.left == null) {
                        node = node.right;
                    }

                    //If node to be deleted has only one left child
                    else if (node.right == null) {
                        node = node.left;
                    }

                    //If node to be deleted has two children node
                    else {
                        //then find the minimum node from right subtree
                        Node temp = minNode(node.right);
                        //Exchange the data between node and temp
                        node.data = temp.data;
                        //Delete the node duplicate node from right subtree
                        node.right = deleteNode(node.right, temp.data);
                    }
                }
                return node;
            }
        }

        //inorder() will perform inorder traversal on binary search tree
        public void inorderTraversal(Node node) {

            //Check whether tree is empty
            if (root == null) {
                System.out.println("Tree is empty");
                return;
            } else {

                if (node.left != null)
                    inorderTraversal(node.left);
                System.out.print(node.data + " ");
                if (node.right != null)
                    inorderTraversal(node.right);

            }
        }

        public Node getRoot() {
            return root;
        }

        /**
         * Java function to check if binary tree is empty or not
         * Time Complexity of this solution is constant O(1) for
         * best, average and worst case.
         *
         * @return true if binary search tree is empty
         */
        public boolean isEmpty() {
            return null == root;
        }


        /**
         * Java function to return number of nodes in this binary search tree.
         * Time complexity of this method is O(n)
         *
         * @return size of this binary search tree
         */
        public int size() {
            Node current = root;
            int size = 0;
            Stack<Node> stack = new Stack<Node>();
            while (!stack.isEmpty() || current != null) {
                if (current != null) {
                    stack.push(current);
                    current = current.left;
                } else {
                    size++;
                    current = stack.pop();
                    current = current.right;
                }
            }
            return size;
        }


        /**
         * Java function to clear the binary search tree.
         * Time complexity of this method is O(1)
         */
        public void clear() {
            root = null;
        }



        public static void main(String[] args) {

            HowToImplementBinarySerachTree bt = new HowToImplementBinarySerachTree();
            //Add nodes to the binary tree
            bt.insert(50);
            bt.insert(30);
            bt.insert(70);
            bt.insert(60);
            bt.insert(10);
            bt.insert(90);

            System.out.println("Binary search tree after insertion:");
            //Displays the binary tree
            bt.inorderTraversal(bt.root);

            Node deletedNode = null;
            //Deletes node 90 which has no child
            deletedNode = bt.deleteNode(bt.root, 90);
            System.out.println("\nBinary search tree after deleting node 90:");
            bt.inorderTraversal(bt.root);

            //Deletes node 30 which has one child
            deletedNode = bt.deleteNode(bt.root, 30);
            System.out.println("\nBinary search tree after deleting node 30:");
            bt.inorderTraversal(bt.root);

            //Deletes node 50 which has two children
            deletedNode = bt.deleteNode(bt.root, 50);
            System.out.println("\nBinary search tree after deleting node 50:");
            bt.inorderTraversal(bt.root);
        }
    }






