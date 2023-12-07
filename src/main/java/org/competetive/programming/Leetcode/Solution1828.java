package org.competetive.programming.Leetcode;

public class Solution1828 {

    public static void main(String[] args) {


    }

    public int[] countPoints(int[][] points, int[][] queries) {

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int count = 0;
            for (int j = 0; j < points.length; j++) {
                if (findSum(points[j], queries[i])) {
                    count++;
                }
            }
            res[i] = count;
        }
        return res;
    }

    private boolean findSum(int[] point, int[] query) {

        return (query[0] - point[0]) * (query[0] - point[0]) + (query[1] - point[1]) * (query[1] - point[1]) -
                query[2] * query[2] <= 0;
    }
}
