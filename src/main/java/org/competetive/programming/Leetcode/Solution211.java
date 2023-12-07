package org.competetive.programming.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution211 {

    TrieNode trie;

    public Solution211() {
        trie = new TrieNode();
    }

    public void addWord(String word) {

        TrieNode root = trie;
        for (Character ch : word.toCharArray()) {
            if (!root.children.containsKey(ch)) {
                root.children.put(ch, new TrieNode());
            }
            root = root.children.get(ch);
        }
        root.word = true;
    }

    public boolean search(String word) {

        TrieNode root = trie;
        return searchInTrie(word, root);
    }

    private boolean searchInTrie(String word, TrieNode root) {

        for (int i = 0; i < word.length(); i++) {
            char key = word.charAt(i);
            if (!root.children.containsKey(key)) {
                if (key == '.') {
                    for (char x : root.children.keySet()) {
                        TrieNode child = root.children.get(x);
                        if (searchInTrie(word.substring(i + 1), child)) {
                            return true;
                        }
                    }
                }
                return false;
            } else {
                root = root.children.get(key);
            }
        }
        return true;
    }
}

class TrieNode {

    Map<Character, TrieNode> children = new HashMap<>();
    boolean word = false;

    public TrieNode() {
    }
}
