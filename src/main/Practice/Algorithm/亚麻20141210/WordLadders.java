package main.Practice.Algorithm.亚麻20141210;

import java.util.*;

public class WordLadders {
    List<List<String>> res;
    Map<String, Integer> ladder;
    Map<String, List<String>> map;

    //Word Ladder II
    public List<List<String>> findLadders2(String beginWord, String endWord, List<String> dict) {
        res = new ArrayList<>();
        map = new HashMap<>();
        if (dict == null || dict.size() == 0) {
            return res;
        }

        ladder = new HashMap<>();
        for (String word : dict) {
            ladder.put(word, Integer.MAX_VALUE);
        }
        ladder.put(beginWord, 0);
        int min = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> used = new HashSet<>();
        used.add(beginWord);
        while (!queue.isEmpty()) {
            String word = queue.poll();
            int step = ladder.get(word) + 1;
            for (int i = 0; i < word.length(); i++) {
                StringBuilder builder = new StringBuilder(word);
                for (char c = 'a'; c <= 'z'; c++) {
                    builder.setCharAt(i, c);
                    String nWord = builder.toString();
                    if (ladder.containsKey(nWord)) {
                        int prevStep = ladder.get(nWord);
                        if (step > prevStep) {
                            continue;
                        } else if (step < prevStep && !used.contains(nWord)) {
                            queue.offer(nWord);
                            used.add(nWord);
                            ladder.put(nWord, step);
                        }
                        // when step == prevStep, we should take into account
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
        if (min == 0) {
            return res;
        } else {
            dfs(new ArrayList<String>(), beginWord, endWord, min);
        }
        return res;
    }

    private void dfs(List<String> list, String beginWord, String endWord, int min) {
        if (list.size() == min && endWord.equals(beginWord)) {
            list.add(0, endWord);
            res.add(new ArrayList<>(list));
            list.remove(0);
            return;
        }
        if (map.containsKey(endWord)) {
            for (String word : map.get(endWord)) {
                list.add(0, endWord);
                dfs(list, beginWord, word, min);
                list.remove(0);
            }
        }

    }

    //Word ladder
    public int findLadders(String beginWord, String endWord, List<String> dict) {
        res = new ArrayList<>();
        if (dict == null || dict.size() == 0) {
            return 0;
        }

        ladder = new HashMap<>();
        for (String word : dict) {
            ladder.put(word, Integer.MAX_VALUE);
        }
        ladder.put(beginWord, 0);

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> used = new HashSet<>();
        used.add(beginWord);
        while (!queue.isEmpty()) {
            String word = queue.poll();
            int step = ladder.get(word);
            for (int i = 0; i < word.length(); i++) {
                StringBuilder builder = new StringBuilder(word);
                for (char c = 'a'; c <= 'z'; c++) {
                    builder.setCharAt(i, c);
                    String nWord = builder.toString();
                    if (ladder.containsKey(nWord)) {
                        step++;
                        if (step >= ladder.get(nWord)) {
                            continue;
                        } else if (!used.contains(nWord)) {
                            queue.offer(nWord);
                            used.add(nWord);
                            ladder.put(nWord, step);
                        }
                    }
                }
            }
        }
        return !ladder.containsKey(endWord) || ladder.get(endWord) == Integer.MAX_VALUE ?
                0 : ladder.get(endWord) + 1;
    }
}
