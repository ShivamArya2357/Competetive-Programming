package org.competetive.programming.Leetcode;

public class Solution1884 {

    public static void main(String[] args) {

    }

    public int twoEggDrop(int n, int e) {

        if (e == 1 || n == 1) {
            return 1;
        }
        int ans = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            ans = Math.min(ans, Math.max(twoEggDrop(i - 1, e - 1), twoEggDrop(n - i, e)) + 1);
        }
        return ans;
    }
}
