package org.competetive.programming.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution2396 {

    public boolean isStrictlyPalindromic(int n) {

        for (int base = 2; base <= n - 2; base++) {
            if (!isPalindrome(convertToBase(n, base))) {
                return false;
            }
        }
        return true;
    }

    private boolean isPalindrome(int[] newBaseNum) {

        int l = 0;
        int r = newBaseNum.length - 1;
        while (l < r) {
            if (newBaseNum[l] != newBaseNum[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    private int[] convertToBase(int n, int base) {

        List<Integer> newBaseDigits = new ArrayList<>();
        while (n > 0) {
            newBaseDigits.add(0, n % base);
            n = n / base;
        }
        return newBaseDigits.stream().mapToInt(Integer::intValue).toArray();
    }
}
