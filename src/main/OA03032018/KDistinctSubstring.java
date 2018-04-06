package main.OA03032018;

import java.util.ArrayList;
import java.util.List;

public class KDistinctSubstring {

    public static void main(String[] args) {
        KDistinctSubstring kd = new KDistinctSubstring();
        for (String s : kd.getSubstrings("ssssabcddddvdss", 4)) {
            System.out.print(s + " ");
        }
    }

    public List<String> getSubstrings(String s, int range) {
        List<String> list = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return list;
        }
        int start = 0;
        int end = 0;
        int lens = s.length();
        int[] hash = new int[26];
        int k = 0;
        while (end < lens) {
            if (hash[s.charAt(end) - 'a'] == 0) {
                k++;
            }
            hash[s.charAt(end) - 'a']++;
            end++;
            while (k == range) {
                if (end - start == range) {
                    list.add(s.substring(start, end));
                }
                hash[s.charAt(start) - 'a']--;
                if (hash[s.charAt(start) - 'a'] == 0) {
                    k--;
                }
                start++;
            }
        }
        return list;
    }
}
