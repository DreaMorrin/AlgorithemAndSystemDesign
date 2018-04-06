package main.LeetCode;

import java.util.*;

/**
 * 451. Sort Characters By Frequency
 Given a string, sort it in decreasing order based on the frequency of characters.

 Example 1:

 Input:
 "tree"

 Output:
 "eert"

 Explanation:
 'e' appears twice while 'r' and 't' both appear once.
 So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 Example 2:

 Input:
 "cccaaa"

 Output:
 "cccaaa"

 Explanation:
 Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 Note that "cacaca" is incorrect, as the same characters must be together.
 Example 3:

 Input:
 "Aabb"

 Output:
 "bbAa"

 Explanation:
 "bbaA" is also a valid answer, but "Aabb" is incorrect.
 Note that 'A' and 'a' are treated as two different characters.

 */

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Map.Entry<Character, Integer>> mapList = new LinkedList<>(map.entrySet());
        Collections.sort(mapList, new Comparator<Map.Entry<Character, Integer>>() {

            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : mapList) {
            for (int i = 0; i < entry.getValue(); i++) {
                builder.append(entry.getKey());
            }
        }
        return builder.toString();
    }
}
