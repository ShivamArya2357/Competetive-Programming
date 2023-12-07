package org.competetive.programming.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution2744 {

    public static void main(String[] args) {

    }

    public int maximumNumberOfStringPairs(String[] words) {

        Map<String, Integer> wordMap = new HashMap<>();
        int count = 0;
        for (String word : words) {
            wordMap.put(word, 1);
        }
        for (String word : words) {
            String reverseWord = reverse(word);
            if (wordMap.containsKey(reverseWord) && !isSameWord(word, reverseWord)) {
                count++;
            }
        }
        return count / 2;
    }

    private boolean isSameWord(String word, String reverseWord) {

        return word.equals(reverseWord);
    }

    private String reverse(String word) {

        StringBuilder sb = new StringBuilder();
        sb.append(word.charAt(1));
        sb.append(word.charAt(0));
        return sb.toString();
    }
}
