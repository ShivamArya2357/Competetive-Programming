package org.competetive.programming.Leetcode;

import java.util.*;

public class Solution139 {

    Map<String, Boolean> dp = new HashMap<>();

    public static void main(String[] args) {

    }

    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> wordSet = new HashSet<>();
        for (String word : wordDict) {
            wordSet.add(word);
        }
        return wordBreak(s, wordSet);
    }

    private boolean wordBreak(String s, Set<String> wordSet) {

        if (s.isEmpty()) {
            return true;
        }
        if (dp.containsKey(s)) {
            return dp.get(s);
        }
        int len = s.length();
        boolean ans = false;
        for (int i = 1; i <= len; i++) {
            String newStr = s.substring(0, i);
            if (wordSet.contains(newStr)) {
                ans = ans || wordBreak(s.substring(i), wordSet);
            }
        }
        dp.put(s, ans);
        return ans;
    }
}
