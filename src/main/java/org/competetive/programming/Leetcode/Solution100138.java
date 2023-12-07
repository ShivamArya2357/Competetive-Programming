package org.competetive.programming.Leetcode;

import java.util.Arrays;

public class Solution100138 {

    public static void main(String[] args) {

    }

    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {

        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int len1 = hBars.length;
        int prev1 = -1;
        int consecutive1 = 0;
        int maxConsecutiveLen1 = 0;
        for (int i = 0; i < len1; i++) {
            if (prev1 == -1) {
                prev1 = hBars[i];
                consecutive1++;
            } else if (prev1 + 1 == hBars[i]) {
                prev1++;
                consecutive1++;
            } else {
                maxConsecutiveLen1 = Math.max(maxConsecutiveLen1, consecutive1);
                consecutive1 = 0;
                prev1 = hBars[i];
            }
        }
        maxConsecutiveLen1 = Math.max(maxConsecutiveLen1, consecutive1);

        int len2 = vBars.length;
        int prev2 = -1;
        int consecutive2 = 0;
        int maxConsecutiveLen2 = 0;
        for (int i = 0; i < len2; i++) {
            if (prev2 == -1) {
                prev2 = vBars[i];
                consecutive2++;
            } else if (prev2 + 1 == vBars[i]) {
                prev2++;
                consecutive2++;
            } else {
                maxConsecutiveLen2 = Math.max(maxConsecutiveLen2, consecutive2);
                consecutive2 = 0;
                prev2 = vBars[i];
            }
        }
        maxConsecutiveLen2 = Math.max(maxConsecutiveLen2, consecutive2);
        int squareSide = Math.min(maxConsecutiveLen1, maxConsecutiveLen2) + 1;
        return squareSide * squareSide;
    }
}
