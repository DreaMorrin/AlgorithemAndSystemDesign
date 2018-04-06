package main.Practice.Algorithm.亚麻20150603;

import java.util.*;

/**
 * 给你一个字典一个，map<Character, Integer>存每个字母的权，
 * 输入是一个List<Character>（可能有重复）让你求这些字母求可以组成最大权数的word list（List<String>）.
 */

public class FindMaxCharacterWeightWordList {
    public List<String> getMaxCharacterWeightWordList(List<String> dict, Map<Character, Integer> wordMap, List<Character> charList) {

        List<String> list = new ArrayList<>();
        if (charList == null || charList.size() == 0) {
            return list;
        }
        int max = Integer.MIN_VALUE;
        Set<String> added = new HashSet<>();
        Collections.sort(charList);
        PriorityQueue<WordWeight> pq = new PriorityQueue<>(new Comparator<WordWeight>() {
            @Override
            public int compare(WordWeight o1, WordWeight o2) {
                return o2.weight - o1.weight;
            }
        });
        for (String word : dict) {
            if (!added.contains(word)) {
                added.add(word);
                WordWeight ww = new WordWeight(word, getWeight(word, wordMap));
                pq.add(ww);
            }
        }
        while (!pq.isEmpty()) {
            WordWeight ww = pq.poll();
            if (added.contains(ww.word) && exist(ww.word, charList)) {
                if (max < ww.weight) {
                    max = ww.weight;
                }
                list.add(ww.word);
            }
        }
        return list;
    }

    private int getWeight(String word, Map<Character, Integer> wordMap) {
        if (word == null || word.length() == 0) {
            return 0;
        }
        int total = 0;
        char[] chars = word.toCharArray();
        for (char c : chars) {
            total += wordMap.get(c);
        }
        return total;
    }

    private boolean exist(String word, List<Character> list) {
        if (word == null || word.length() == 0 || list == null || list.size() == 0) {
            return false;
        }
        boolean contains = true;
        for (char c : word.toCharArray()) {
            if (!contains) {
                return false;
            }
            boolean hasChar = false;
            int start = 0;
            int end = list.size() - 1;
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (list.get(mid) < c) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
            if (list.get(start) == c || list.get(end) == c) {
                hasChar = true;
            }
            contains &= hasChar;
        }
        for (char c : word.toCharArray()) {
            list.remove(c);
        }
        return true;
    }
}
