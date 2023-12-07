package org.competetive.programming.Leetcode;

public class Solution2149 {

    public static void main(String[] args) {


    }

    public int[] rearrangeArray(int[] nums) {

        int n = nums.length;
        int[] res = new int[n];
        int count = 0;
        int posit = 0;
        int negat = 0;
        while (posit < n && negat < n) {
            while (nums[posit] < 0) {
                posit++;
            }
            while (nums[negat] > 0) {
                negat++;
            }
            res[count++] = nums[posit];
            res[count++] = nums[negat];
            posit++;
            negat++;
        }
        return res;
    }
}
