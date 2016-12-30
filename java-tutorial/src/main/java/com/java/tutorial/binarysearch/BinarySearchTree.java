package com.java.tutorial.binarysearch;

/**
 * Created by isa.kalinsaz on 09/12/2016.
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node {

        private Key key;
        private Value val;
        private Node left, right;
        private int size;

        public Node(Key key, Value val, int size) {
            this.size = size;
            this.key = key;
            this.val = val;
            this.left = this.right = null;
        }
    }

    public BinarySearchTree() {

    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {

        if (x == null)
            return 0;
        else
            return x.size;
    }

    public boolean contains(Key key) {
        if (key == null)
            throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node root, Key key) {
        if (root == null) return null;
        int cmp = key.compareTo(root.key);
        if (cmp < 0)
            return get(root.left, key);
        else
            return get(root.right, key);

    }


}
