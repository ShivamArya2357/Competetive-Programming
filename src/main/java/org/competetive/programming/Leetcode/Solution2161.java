package org.competetive.programming.Leetcode;


public class Solution2161 {

    private int p;

    public static void main(String[] args) {

    }

    public int[] pivotArray(int[] nums, int pivot) {

        int[] res = new int[nums.length];
        int index = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) {
                res[index++] = nums[i];
            } else if (nums[i] == pivot) {
                count++;
            }
        }
        while (count > 0) {
            res[index++] = pivot;
            count--;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > pivot) {
                res[index++] = nums[i];
            }
        }
        return res;
    }
}
