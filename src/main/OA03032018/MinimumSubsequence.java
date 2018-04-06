package main.OA03032018;

import java.util.HashMap;
import java.util.Map;

public class MinimumSubsequence {

    public static void main(String[] args) {
        MinimumSubsequence ms = new MinimumSubsequence();
        String[] seq = new String[]{"made","weather","forecast","says", "that",
                "made", "run", "in", "made", "made", "this", "that", "in", "run", "made"};
        String[] target = new String[]{"made", "in", "run", "made"};
        for (int i : ms.getSubsequence(seq, target)) {
            System.out.println(i);
        }
    }

    public int[] getSubsequence(String[] source, String[] target) {
        int[] res = new int[2];
        if (source == null || source.length == 0 ||
                target == null || target.length == 0 ||
                source.length < target.length) {
            return res;
        }

        Map<String, Integer> hash = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            hash.put(target[i], hash.getOrDefault(target[i], 0) + 1);
        }
        int index = 0;
        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        int count = target.length;
        while (end < source.length) {
            if (hash.containsKey(source[end])) {
                int val = hash.get(source[end]);
                hash.put(source[end], val - 1);
                if (hash.get(source[end]) >= 0) {
                    index++;
                    count--;
                }
            }

            while (count == 0) {

                if (start < source.length && hash.containsKey(source[start])) {
                    if (hash.get(source[start]) >= 0) {
                        if (end - start < min) {
                                min = end - start;
                                res[0] = start;
                                res[1] = end;
                        }
                        count++;
                    }
                    hash.put(source[start], hash.get(source[start]) + 1);
                }
                start++;
            }
            end++;
        }
        return res;
    }


}
