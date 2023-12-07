package org.competetive.programming.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution2265 {

    private int ans = 0;

    private Map<TreeNode, Integer> subTreeCountMap = new HashMap<>();

    public static void main(String[] args) {

    }

    // 1. First Approach
//    public int averageOfSubtree(TreeNode root) {
//
//        subTreeCount(root);
//        subTreeSum(root);
//        return ans;
//    }
//
//    private int subTreeCount(TreeNode root) {
//
//        if (root == null) {
//            return 0;
//        } else {
//            int subtreeCount = 1 + subTreeCount(root.left) + subTreeCount(root.right);
//            subTreeCountMap.put(root, subtreeCount);
//            return subtreeCount;
//        }
//    }
//
//    private int subTreeSum(TreeNode root) {
//
//        if (root == null) {
//            return 0;
//        } else {
//            int subTreeSum = root.val + subTreeSum(root.left) + subTreeSum(root.right);
//            int count = subTreeCountMap.get(root);
//            if (subTreeSum / count == root.val) {
//                ans++;
//            }
//            return subTreeSum;
//        }
//    }

    // 2. Second Approach
    public int averageOfSubtree(TreeNode root) {

        avg(root);
        return ans;
    }

    private Pair<Integer, Integer> avg(TreeNode root) {

        if (root == null) {
            return new Pair<>(0, 0);
        } else {
            Pair<Integer, Integer> leftPair = avg(root.left);
            Pair<Integer, Integer> rightPair = avg(root.right);
            Pair<Integer, Integer> newPair = new Pair<>(leftPair.getKey() + rightPair.getKey() + root.val ,
                    1 + leftPair.getValue() + rightPair.getValue()
            );
            if (newPair.getKey() / newPair.getValue() == root.val) {
                ans++;
            }
            return newPair;
        }
    }
}