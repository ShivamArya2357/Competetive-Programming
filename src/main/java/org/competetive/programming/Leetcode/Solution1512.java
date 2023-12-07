package org.competetive.programming.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution1512 {

    public static void main(String[] args) {


    }

    public int numIdenticalPairs(int[] nums) {

        int size = nums.length;
        Map<Integer, Integer> freqMap = new HashMap<>();
        int freqCount;
        int totalGoodPairs = 0;
        for (int i = 0; i < size; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            freqCount = entry.getValue();
            if (freqCount > 1) {
                totalGoodPairs += (freqCount * (freqCount - 1)) / 2;
            }
        }
        return totalGoodPairs;
    }
}
