package org.competetive.programming.Leetcode;

public class Solution2340 {

    public static void main(String[] args) {


    }

    public int minimumSwaps(int[] nums) {

        int n = nums.length;
        int maxEle = Integer.MIN_VALUE;
        int maxDistance = 0;
        int index1 = -1;
        int minEle = Integer.MAX_VALUE;
        int minDistance = 0;
        int index2 = -1;
        for (int i = 0; i < n; i++) {
            if (maxEle <= nums[i]) {
                maxEle = nums[i];
                maxDistance = n - i - 1;
                index1 = i;
            }
            if (minEle > nums[i]) {
                minEle = nums[i];
                minDistance = i;
                index2 = i;
            }
        }
        return (index1 < index2) ? maxDistance + minDistance - 1 : maxDistance + minDistance;
    }
}
