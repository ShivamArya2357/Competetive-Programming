package org.competetive.programming.Leetcode;

public class Solution75 {

    public static void main(String[] args) {

    }

    public void sortColors(int[] nums) {

        int n = nums.length;
        int l = 0;
        int r = n - 1;
        int i = 0;
        while (i < n) {
            if (nums[i] == 0) {
                while (l < n && nums[l] == 0) {
                    l++;
                }
                if (l < n) {
                    swap(nums, i, l);
                    i++;
                    l++;
                }
            } else if (nums[i] == 2) {
                while (r >= 0 && nums[r] == 2) {
                    r--;
                }
                if (r >= 0) {
                    swap(nums, i, r);
                    i++;
                    r--;
                }
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
