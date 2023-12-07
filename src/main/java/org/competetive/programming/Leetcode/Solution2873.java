package org.competetive.programming.Leetcode;

public class Solution2873 {

    public static void main(String[] args) {

    }

    public long maximumTripletValue(int[] nums) {

        int len = nums.length;
        long res = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                for (int k = j + 1; k < len; k++) {
                    long value = (long) (nums[i] - nums[j]) * nums[k];
                    res = Math.max(res, value);
                }
            }
        }
        return res;
    }
}
