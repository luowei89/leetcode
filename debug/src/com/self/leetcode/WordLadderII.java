package com.self.leetcode;

import java.util.*;

/**
 * Created by luowei on 2/17/16.
 * 126. Word Ladder II
 */
public class WordLadderII {

    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        // All words have the same length.
        // All words contain only lowercase alphabetic characters.
        Queue<List<String>> queue = new LinkedList();
        boolean found = false;
        List<List<String>> result = new ArrayList<>();
        List<String> beginList = new ArrayList<>();
        beginList.add(beginWord);
        queue.add(beginList);
        wordList.remove(beginWord);
        queue.add(null);
        Set<String> level = new HashSet<>();
        while(queue.size() > 1) {
            List<String> node = queue.poll();
            if (node == null) {
                wordList.removeAll(level);
                level = new HashSet<>();
                queue.add(null);
                continue;
            }
            String tail = node.get(node.size()-1);
            List<String> candidates = getCandidates(tail, endWord, wordList);
            if (candidates == null) {
                found = true;
                List<String> list = new ArrayList<>(node);
                list.add(endWord);
                result.add(list);
            }
            if (!found) {
                for (String str : candidates) {
                    List<String> list = new ArrayList<>(node);
                    list.add(str);
                    queue.add(list);
                    level.add(str);
                }
            }
        }
        return result;
    }

    private List<String> getCandidates(String word, String endWord, Set<String> wordList) {
        List<String> result = new ArrayList<>();
        int n = word.length();
        char[] wordChars = word.toCharArray();
        for (int i = 0; i < n; i++) {
            char original = wordChars[i];
            for (char c  = 'a'; c <= 'z'; c++) {
                if (c != original) {
                    wordChars[i] = c;
                    String candidate = new String(wordChars);
                    if (endWord.equals(candidate)) {
                        return null;
                    }
                    if (wordList.contains(candidate)) {
                        result.add(candidate);
                    }
                }
            }
            wordChars[i] = original;
        }
        return result;
    }
}
