package org.competetive.programming.Leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solution1874 {

    public static void main(String[] args) {


    }

    public int minProductSum(int[] nums1, int[] nums2) {

        int len = nums2.length;
        Integer[] newArr = new Integer[len];
        for (int i = 0; i < len; i++) {
            newArr[i] = nums2[i];
        }
        Arrays.sort(nums1);
        Arrays.sort(newArr, Collections.reverseOrder());
        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans += nums1[i] * newArr[i];
        }
        return ans;
    }
}

class ReverseOrder implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}
