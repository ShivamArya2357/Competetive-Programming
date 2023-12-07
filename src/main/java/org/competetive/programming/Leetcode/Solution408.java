package org.competetive.programming.Leetcode;

public class Solution408 {

    public static void main(String[] args) {


    }

    public boolean validWordAbbreviation(String word, String abbr) {

        int wordLen = word.length();
        int len = abbr.length();
        int i = 0;
        int j = 0;
        while (i < len) {
            if (Character.isDigit(abbr.charAt(i)) && abbr.charAt(i) != '0') {
                int steps = 0;
                while (i < len && Character.isDigit(abbr.charAt(i))) {
                    int digit = abbr.charAt(i) - '0';
                    steps = steps * 10 + digit;
                    i++;
                }
                j += steps;
            }
            if (i == len && j == wordLen) {
                return true;
            } else if (j < wordLen && i < len && word.charAt(j) == abbr.charAt(i)) {
                i++;
                j++;
            } else {
                return false;
            }
        }
        return (i == len && j == wordLen);
    }

    private boolean isNumInRange(int num, int digit) {

        if (num > Integer.MAX_VALUE / 10) {
            return false;
        } else if (num < Integer.MAX_VALUE / 10) {
            return true;
        } else {
            return digit >= 0 && digit <= 7;
        }
    }
}
