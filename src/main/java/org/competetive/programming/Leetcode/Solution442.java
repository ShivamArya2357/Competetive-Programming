package org.competetive.programming.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution442 {

    public static void main(String[] args) {

    }

    public List<Integer> findDuplicates(int[] nums) {

        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        int i = 0;
        while (i < n) {
            int val = nums[i];
            int temp;
            while (true) {
                if (nums[val - 1] == val - 1) {
                    res.add(val);
                    break;
                }
                temp = nums[val - 1];
                nums[val - 1] = val;
                val = temp;
            }
            i++;
        }
        return res;
    }
}
