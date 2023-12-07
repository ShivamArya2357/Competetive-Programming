package org.competetive.programming.Leetcode;

public class Solution1689 {

    public static void main(String[] args) {


    }

    public int minPartitions(String n) {

        int maxNum = 0;
        for (int i = 0; i < n.length(); i++) {
            maxNum = Math.max(maxNum, n.charAt(i) - '0');
        }
        return maxNum;
    }
}
