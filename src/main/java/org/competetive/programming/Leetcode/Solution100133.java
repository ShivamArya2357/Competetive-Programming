package org.competetive.programming.Leetcode;

public class Solution100133 {

    public static void main(String[] args) {

    }

    public int minimumCoins(int[] prices) {

        int n = prices.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = -1;
        }
        return solve(prices, dp, 0, n);
    }

    private int solve(int[] prices, int[] dp, int i, int n) {

        if (i >= n) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        return (dp[i] = Math.min(prices[i] + solve(prices, dp,i + 2, n), prices[i] + solve(prices, dp,i + 1, n)));
    }
}
