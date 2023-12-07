package org.competetive.programming.Leetcode;

public class Solution557 {

    public static void main(String[] args) {

        String ans = reverseWords("Let's take LeetCode contest");
        System.out.println(ans);
    }

//    1. First Approach
//    private static String reverseWords(String s) {
//
//        String[] words = s.split(" ");
//        int totalWords = words.length;
//        StringBuilder reverseSB = new StringBuilder();
//        for (int i = 0; i < totalWords; i++) {
//            StringBuilder sb = new StringBuilder(words[i]);
//            sb.reverse();
//            if (i == totalWords - 1) {
//                reverseSB.append(sb);
//            } else {
//                reverseSB.append(sb + " ");
//            }
//        }
//        return reverseSB.toString();
//    }

    //    2. Second Approach
    public static String reverseWords(String s) {

        int l = 0;
        int r = 0;
        char[] chars = s.toCharArray();
        int len = chars.length;
        while (r < len) {
            if (chars[r] == ' ') {
                reverse(chars, l, r - 1);
                r++;
                l = r;
            } else {
                r++;
            }
        }
        reverse(chars, l, r - 1);
        return new String(chars);
    }

    private static void reverse(char[] chars, int l, int r) {

        while (l < r) {
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            l++;
            r--;
        }
    }
}
