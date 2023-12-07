package org.competetive.programming.Leetcode;

public class Solution2391 {

    public static void main(String[] args) {

    }

    public int garbageCollection(String[] garbage, int[] travel) {

        int lastIndexOfM = -1;
        int lastIndexOfP = -1;
        int lastIndexOfG = -1;
        for (int i = 0; i < garbage.length; i++) {
            if (garbage[i].contains("M")) {
                lastIndexOfM = i;
            }
            if (garbage[i].contains("P")) {
                lastIndexOfP = i;
            }
            if (garbage[i].contains("G")) {
                lastIndexOfG = i;
            }
        }
        int ans = garbage[0].length();
        int truckCount = 0;
        for (int i = 1; i < garbage.length; i++) {
            if (lastIndexOfM >= i) {
                truckCount++;
            }
            if (lastIndexOfP >= i) {
                truckCount++;
            }
            if (lastIndexOfG >= i) {
                truckCount++;
            }
            ans += truckCount * travel[i - 1] + garbage[i].length();
        }
        return ans;
    }
}
