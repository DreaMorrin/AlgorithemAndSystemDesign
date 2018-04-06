package main.LeetCode;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Integer> ladder = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> used = new HashSet<>();
        queue.offer(beginWord);
        used.add(beginWord);

        if (!wordList.contains(endWord)) {
            return 0;
        }

        for (String word : wordList) {
            ladder.put(word, Integer.MAX_VALUE);
        }
        ladder.put(beginWord, 0);
        int lens = beginWord.length();
        int min = 0;
        while (!queue.isEmpty()) {
            String word = queue.poll();
            int step = ladder.get(word);
            for (int i = 0; i < word.length(); i++) {
                StringBuilder builder = new StringBuilder(word);
                for (char c = 'a'; c <= 'z'; c++) {
                    builder.setCharAt(i, c);
                    String nWord = builder.toString();
                    if (ladder.containsKey(nWord)) {
                        if (step > ladder.get(nWord)) {
                            continue;
                        } else if (!used.contains(nWord)) {
                            used.add(nWord);
                            queue.offer(nWord);
                            ladder.put(nWord, step + 1);
                        }
                    }
                }
            }
        }
        return ladder.get(endWord) == Integer.MAX_VALUE ? 0 : ladder.get(endWord) + 1;
    }
}
