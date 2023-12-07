package org.competetive.programming.Leetcode;

public class Solution1768 {

    public static void main(String[] args) {

    }

    public String mergeAlternately(String word1, String word2) {

        int wordLen1 = word1.length();
        int wordLen2 = word2.length();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < Math.min(wordLen1, wordLen2)) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
            i++;
        }
        while (i < wordLen1) {
            sb.append(word1.charAt(i));
            i++;
        }
        while (i < wordLen2) {
            sb.append(word2.charAt(i));
            i++;
        }
        return sb.toString();
    }
}
