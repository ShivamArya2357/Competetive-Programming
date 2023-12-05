package org.competetive.programming.Leetcode;

import java.util.Arrays;

public class Solution1769 {

    public static void main(String[] args) {

    }

    // 1. Approach
//    public int[] minOperations(String boxes) {
//
//        int[] res = new int[boxes.length()];
//        for (int i = 0; i < boxes.length(); i++) {
//            int ans = 0;
//            for (int j = 0; j < boxes.length(); j++) {
//                if (i != j && boxes.charAt(j) == '1') {
//                    ans += Math.abs(i - j);
//                }
//            }
//            res[i] = ans;
//        }
//        return res;
//    }

    public int[] minOperations(String boxes) {

        int n = boxes.length();
        int[] res = new int[n];
        Arrays.fill(res, 0);
        int countOfOnes = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                res[i] = res[i - 1] + countOfOnes;
            }
            if (boxes.charAt(i) == '1') {
                countOfOnes++;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
        countOfOnes = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i + 1 < n) {
                res[i] += res[i + 1] + countOfOnes;
            }
            if (boxes.charAt(i) == '1') {
                countOfOnes++;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
        return res;
    }
}
