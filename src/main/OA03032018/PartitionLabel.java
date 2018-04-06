package main.OA03032018;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabel {
    public static void main(String[] args) {
        PartitionLabel pl = new PartitionLabel();
        for (int i : pl.label("ababcbacadefegdehijhklij")) {
            System.out.println(i);
        }
    }

    public List<Integer> label(String s) {
        List<Integer> list = new ArrayList<>();
        int[] hash = new int[26];
        int lens = s.length();
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a'] = i;
        }
//        for (int i = 0; i < 26; i++) {
//            System.out.println(hash[i]);
//        }
        int start = -1;
        int end = -1;
        for (int i = 0; i < lens; i++) {
            if (start == -1) {
                start = i;
            }
            System.out.println(hash[s.charAt(i) - 'a'] + " " + end);
            end = Math.max(end, hash[s.charAt(i) - 'a']);
            if (end == i) {
//                System.out.println(start + ", " + end);
                list.add(end - start + 1);
                start = -1;
            }
        }
        return list;
    }
}
