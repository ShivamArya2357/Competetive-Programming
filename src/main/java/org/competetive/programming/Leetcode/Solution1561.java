package org.competetive.programming.Leetcode;

import java.util.Arrays;
import java.util.Collections;

public class Solution1561 {

    public static void main(String[] args) {

    }

    public int maxCoins(int[] piles) {

        Integer[] newPiles = new Integer[piles.length];
        for (int i = 0; i < piles.length; i++) {
            newPiles[i] = piles[i];
        }
        Arrays.sort(newPiles);
        int l = 0;
        int r = newPiles.length - 2;
        int maxCoin = 0;
        while (l < r) {
            maxCoin += newPiles[r];
            l++;
            r -= 2;
        }
        return maxCoin;
    }
}
