package org.competetive.programming.Leetcode;

public class Solution2433 {

    public static void main(String[] args) {

    }

    public int[] findArray(int[] pref) {

        int n = pref.length;
        for (int i = 1; i < n; i++) {
            pref[i] ^= pref[i - 1];
        }
        return pref;
    }
}
