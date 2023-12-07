package org.competetive.programming.Leetcode;

public class Solution2874 {

    public static void main(String[] args) {


    }

    public long maximumTripletValue(int[] nums) {

        int len = nums.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        leftMax[0] = nums[0];
        for (int i = 1; i < len; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], nums[i]);
        }
        rightMax[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
        }
        long ans = 0;
        for (int i = 1; i < len - 1; i++) {
            ans = Math.max(ans, (long) (leftMax[i - 1] - nums[i]) * rightMax[i + 1]);
        }
        return ans;
    }
}
