package org.competetive.programming.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {

    public static void main(String[] args) {

    }

    // 1. First Approach
//    public int[] twoSum(int[] nums, int target) {
//
//        int len = nums.length;
//        int[][] newArr = new int[len][2];
//        for (int i = 0; i < len; i++) {
//            newArr[i][0] = nums[i];
//            newArr[i][1] = i;
//        }
//        Arrays.sort(newArr, Comparator.comparingInt(o -> o[0]));
//        int l = 0;
//        int r = len - 1;
//        while (l < r) {
//            if (newArr[l][0] + newArr[r][0] == target) {
//                return new int[]{newArr[l][1], newArr[r][1]};
//            } else if (newArr[l][0] + newArr[r][0] < target) {
//                l++;
//            } else {
//                r--;
//            }
//        }
//        return new int[]{-1,-1};
//    }

    //    2. Second Approach
    public int[] twoSum(int[] nums, int target) {

        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int key = target - nums[i];
            if (!map.containsKey(key)) {
                map.put(nums[i], i);
            } else {
                return new int[]{map.get(key), i};
            }
        }
        return new int[]{-1,-1};
    }
}
