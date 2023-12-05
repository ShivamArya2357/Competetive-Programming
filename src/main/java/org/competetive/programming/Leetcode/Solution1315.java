package org.competetive.programming.Leetcode;

public class Solution1315 {

    int ans = 0;

    public static void main(String[] args) {

    }

    public int sumEvenGrandparent(TreeNode root) {

        sum(root, false, false);
        return ans;
    }

    private void sum(TreeNode root, boolean isParentEven, boolean isGrandParentEven) {

        if (root == null) {
            return;
        }
        if (isGrandParentEven) {
            ans += root.val;
        }
        if (isParentEven) {
            sum(root.left, root.val % 2 == 0, true);
            sum(root.right, root.val % 2 == 0, true);
        } else {
            sum(root.left, root.val % 2 == 0, false);
            sum(root.right, root.val % 2 == 0, false);
        }
    }
}


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}
