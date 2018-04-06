package main.OA03032018;

import java.util.ArrayList;
import java.util.List;

public class DistinctCharLessThanK {
    public static void main(String[] args) {
        DistinctCharLessThanK obj = new DistinctCharLessThanK();
        for (String str : obj.distinctCharLessThanK("kjhkhlkhkhkjh", 4)) {
            System.out.println(str);
        }
    }

    public List<String> distinctCharLessThanK(String source, int k) {
        List<String> list = new ArrayList<>();
        if (source == null || source.length() == 0) {
            return list;
        }

        int[] hash = new int[26];
        int start = 0;
        int end = 0;
        int count = 0;
        int lens = source.length();
        while (end < lens) {
            if (hash[source.charAt(end) - 'a'] == 0) {
                count++;
            }
            hash[source.charAt(end) - 'a']++;
            end++;
            if (count == k - 1 && end - start == k) {
                list.add(source.substring(start, end));
            }

            if (end - start == k) {
                if (hash[source.charAt(start) - 'a'] == 1) {
                    count--;
                }
                hash[source.charAt(start) - 'a']--;
                start++;
            }
        }
        return list;
    }
}
