package org.competetive.programming.Leetcode;

public class Solution2405 {

    public static void main(String[] args) {

    }

    public int partitionString(String s) {

        int len = s.length();
        int count = 0;
        int[] freq = new int[26];
        boolean flag = false;
        init(freq);
        for (int i = 0; i < len; i++) {
            if (freq[s.charAt(i) - 'a'] == 0) {
                freq[s.charAt(i) - 'a'] = 1;
                flag = true;
            } else {
                count++;
                init(freq);
                freq[s.charAt(i) - 'a'] = 1;
                flag = false;
            }
        }
        return flag ? count + 1 : count;
    }

    private void init(int[] freq) {

        for (int i = 0; i < 26; i++) {
            freq[i] = 0;
        }
    }
}
