package org.competetive.programming.Leetcode;

import java.util.Arrays;

public class Solution2798 {

    public static void main(String[] args) {


    }

    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {

        Arrays.sort(hours);
        int size = hours.length;
        int l = 0;
        int h = size - 1;
        int mid;
        int index = -1;
        while (l <= h) {
            mid = l + (h - l) / 2;
            if (hours[mid] < target) {
                index = mid;
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return size - index - 1;
    }
}
