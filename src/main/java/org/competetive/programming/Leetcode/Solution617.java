package org.competetive.programming.Leetcode;

import java.util.Stack;

public class Solution617 {

    // 1. First Approach using recursion
//    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
//
//        if ((root1 == null || root1 != null) && root2 == null) {
//            return root1;
//        } else if (root1 == null && root2 != null) {
//            return root2;
//        } else {
//            root1.val += root2.val;
//            root1.left = mergeTrees(root1.left, root2.left);
//            root1.right = mergeTrees(root1.right, root2.right);
//            return root1;
//        }
//    }

    // 2. Iterative Approach
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{root1, root2});
        while (!stack.isEmpty()) {
            TreeNode[] top = stack.pop();
            TreeNode firstTree = top[0];
            TreeNode secondTree = top[1];
            if (firstTree.left == null && secondTree.left != null) {
                firstTree.left = secondTree.left;
            }
            if (firstTree.right == null && secondTree.right != null) {
                firstTree.right = secondTree.right;
            }
            if (firstTree.left != null && secondTree.left != null) {
                firstTree.val += secondTree.val;
                stack.push(new TreeNode[]{firstTree.left, secondTree.left});
            }
            if (firstTree.right != null && secondTree.right != null) {
                firstTree.val += secondTree.val;
                stack.push(new TreeNode[]{firstTree.right, secondTree.right});
            }
        }
        return root1;
    }
}
