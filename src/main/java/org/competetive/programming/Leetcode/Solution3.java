package org.competetive.programming.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {

    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> indexMap = new HashMap<>();
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        int lastInvalidatedIndex = -1;
        int l = 0;
        int r = 1;
        int ans = 1;
        indexMap.put(s.charAt(0), 0);
        while (r < len) {
            if (indexMap.containsKey(s.charAt(r)) &&
                    indexMap.get(s.charAt(r)) <= lastInvalidatedIndex
            ) {
                ans = Math.max(ans, r - l + 1);
            } else if (indexMap.containsKey(s.charAt(r))) {
                lastInvalidatedIndex = indexMap.get(s.charAt(r));
                l = lastInvalidatedIndex + 1;
            }
            ans = Math.max(ans, r - l + 1);
            indexMap.put(s.charAt(r), r);
            r++;
        }
        return ans;
    }
}
