package org.pg4200.ex05;

import org.pg4200.les05.MyMapBinarySearchTree;

public class BinaryTreeLeftMaxDelete extends MyMapBinarySearchTree {

    @Override
    protected TreeNode delete(Comparable key, TreeNode subtreeRoot) {

        if (subtreeRoot == null) return null;

        int cmp = key.compareTo(subtreeRoot.key);

        if (cmp < 0) {
            subtreeRoot.left = delete(key, subtreeRoot.left);
            return subtreeRoot;
        }

        if (cmp > 0) {
            subtreeRoot.right = delete(key, subtreeRoot.right);
            return subtreeRoot;
        }

        assert cmp == 0;

        size--;

        if (subtreeRoot.left == null) {
            return subtreeRoot.right;
        }

        if (subtreeRoot.right == null) {
            return subtreeRoot.left;
        }

        assert subtreeRoot.left != null && subtreeRoot.right != null;

        TreeNode tmp = subtreeRoot;
        subtreeRoot = max(tmp.left);
        subtreeRoot.left = deleteMax(tmp.left);
        subtreeRoot.right = tmp.right;

        return subtreeRoot;
    }

    private TreeNode deleteMax(TreeNode subtreeRoot) {
        if (subtreeRoot.right == null) return subtreeRoot.left;

        subtreeRoot.right = deleteMax(subtreeRoot.right);

        return subtreeRoot;
    }

    private TreeNode max(TreeNode subtreeRoot) {
        if (subtreeRoot.right == null) return subtreeRoot;
        return max(subtreeRoot.right);
    }
}
