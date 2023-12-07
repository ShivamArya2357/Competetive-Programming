package org.competetive.programming.Leetcode;

import java.util.*;

public class Solution1409 {

    public static void main(String[] args) {

    }

    public int[] processQueries(int[] queries, int m) {

        Deque<Integer> permutations = new ArrayDeque<>();
        int[] ans = new int[queries.length];
        for (int i = 1; i <= m; i++) {
            permutations.add(i);
        }
        for (int i = 0; i < queries.length; i++) {
            int index = 0;
            for (Integer num : permutations) {
                if (queries[i] == num) {
                    ans[i] = index;
                    permutations.remove(num);
                    permutations.addFirst(num);
                    break;
                }
                index++;
            }
        }
        return ans;
    }
}
