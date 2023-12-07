package org.competetive.programming.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution100121 {

    public static void main(String[] args) {


    }

    public List<Integer> findWordsContaining(String[] words, char x) {

        int len = words.length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            char[] characters = words[i].toCharArray();
            for (char ch : characters) {
                if (ch == x) {
                    res.add(i);
                    break;
                }
            }
        }
        return res;
    }
}
