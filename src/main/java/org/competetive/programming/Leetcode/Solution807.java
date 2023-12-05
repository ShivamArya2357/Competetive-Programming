package org.competetive.programming.Leetcode;

public class Solution807 {

    public static void main(String[] args) {

    }

    public int maxIncreaseKeepingSkyline(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        int[] maxRowSkyline = new int[n];
        int[] maxColSkyline = new int[m];
        for (int row = 0; row < n; row++) {
            int maxSkyline = 0;
            for (int col = 0; col < m; col++) {
                maxSkyline = Math.max(maxSkyline, grid[row][col]);
            }
            maxRowSkyline[row] = maxSkyline;
        }
        for (int col = 0; col < m; col++) {
            int maxSkyline = 0;
            for (int row = 0; row < n; row++) {
                maxSkyline = Math.max(maxSkyline, grid[row][col]);
            }
            maxColSkyline[col] = maxSkyline;
        }
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                ans += Math.min(maxRowSkyline[row], maxColSkyline[col]) - grid[row][col];
            }
        }
        return ans;
    }
}
