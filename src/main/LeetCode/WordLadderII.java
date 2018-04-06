package main.LeetCode;

import java.util.*;

public class WordLadderII {
    Map<String, Integer> ladder;
    Map<String, List<String>> map;
    List<List<String>> results = new ArrayList<>();
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> used = new HashSet<>();
        map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        ladder = new HashMap<>();
        for (String word : wordList) {
            ladder.put(word, Integer.MAX_VALUE);
        }
        ladder.put(beginWord, 0);
        int min = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            String word = queue.poll();
            int step = ladder.get(word) + 1;
            for (int i = 0; i < word.length(); i++) {
                StringBuilder builder = new StringBuilder(word);
                for (char c = 'a'; c <= 'z'; c++) {
                    builder.setCharAt(i, c);
                    String nWord = builder.toString();
                    if (ladder.containsKey(nWord)) {
                        if (step > ladder.get(nWord)) {
                            continue;
                        } else if (step < ladder.get(nWord) && !used.contains(nWord)) {
                            queue.offer(nWord);
                            used.add(nWord);
                            ladder.put(nWord, step);
                        }
                        if (map.containsKey(nWord)) {
                            map.get(nWord).add(word);
                        } else {
                            List<String> nList = new ArrayList<>();
                            nList.add(word);
                            map.put(nWord, nList);
                        }
                        if (nWord.equals(endWord)) {
                            min = step;
                        }
                    }
                }
            }
        }
        List<String> solution = new ArrayList<>();
        getSolutions(beginWord, endWord, solution, min);
        return results;
    }
    private void getSolutions(String begin, String end, List<String> list, int min) {
        if (list.size() == min && end.equals(begin)) {
            list.add(0, begin);
            results.add(new ArrayList<String>(list));
            list.remove(0);
            return;
        }
        if (map.containsKey(end)) {
            for (String s : map.get(end)) {
                list.add(0, end);
                getSolutions(begin, s, list, min);
                list.remove(0);
            }
        }
    }
}
