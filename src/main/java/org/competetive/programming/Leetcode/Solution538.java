package org.competetive.programming.Leetcode;

public class Solution538 {

    public static void main(String[] args) {

    }

    public TreeNode convertBST(TreeNode root) {

        int sum = 0;
        while (root != null) {
            if (root.right == null) {
                sum += root.val;
                root.val = sum;
                root = root.left;
            } else {
                TreeNode leftMostNode = root.right;
                while (leftMostNode.left != null && leftMostNode.left != root) {
                    leftMostNode = leftMostNode.left;
                }
                if (leftMostNode.left == null) {
                    leftMostNode.left = root;
                    root = root.right;
                } else {
                    sum += root.val;
                    root.val = sum;
                    leftMostNode.left = null;
                    root = root.left;
                }
            }
        }
        return root;
    }
}
