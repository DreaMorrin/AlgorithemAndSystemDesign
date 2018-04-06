package main.OA03032018;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagrams {

    public static void main(String[] args) {
        FindAllAnagrams faa = new FindAllAnagrams();
        for (int i : faa.getAnagramsIndex("cbaebabacd", "abc")) {
            System.out.println(i);
        }

    }

    public List<Integer> getAnagramsIndex(String source, String target) {
        List<Integer> list = new ArrayList<>();
        if (source == null || source.length() == 0 ||
                target == null || target.length() == 0 ||
                source.length() < target.length()) {
            return list;
        }

        int[] hash = new int[26];
        for (int i = 0; i < target.length(); i++) {
            hash[target.charAt(i) - 'a']++;
        }
        int count  = target.length();
        int start = 0;
        int end = 0;
        while (end < source.length()) {
            if (hash[source.charAt(end) - 'a'] > 0) {
                count--;
            }
            hash[source.charAt(end) - 'a']--;
            end++;
            if (count == 0) {
                list.add(start);
            }
            if (end - start == target.length()) {
                if (hash[source.charAt(start) - 'a'] >= 0) {
                    count++;
                }
                hash[source.charAt(start) - 'a']++;
                start++;
            }
        }
        return list;
    }
}
