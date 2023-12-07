package org.competetive.programming.Leetcode;

public class Solution2944 {

    public static void main(String[] args) {

    }

    public int minimumCoins(int[] prices) {

        int n = prices.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = -1;
        }
        int ans = prices[0];
        return solve(prices, ans, dp, 1, n);
    }

    private int solve(int[] prices, int ans, int[] dp, int i, int n) {

        if (i >= n) {
            return 0;
        }

        for (int k = i + 1; k < 2 * i + 1; k++) {
            ans = Math.max(ans, Math.max(prices[k - 1] + solve(prices, ans, dp, i + 2, n),
                    solve(prices, ans,dp, i + 2, n))
            );
        }
        return ans;
    }
}
