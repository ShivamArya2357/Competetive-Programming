package org.competetive.programming.Leetcode;

public class Solution654 {

    public static void main(String[] args) {

    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {

        return constructBinaryTree(nums, 0, nums.length - 1);
    }

    private TreeNode constructBinaryTree(int[] nums, int l, int r) {

        if (l > r) {
            return null;
        }
        int maxNumIndex = l;
        for (int i = l + 1; i <= r; i++) {
            if (nums[maxNumIndex] < nums[i]) {
                maxNumIndex = i;
            }
        }
        TreeNode node = new TreeNode(nums[maxNumIndex], null, null);
        node.left = constructBinaryTree(nums, l, maxNumIndex - 1);
        node.right = constructBinaryTree(nums, maxNumIndex + 1, r);
        return node;
    }
}
