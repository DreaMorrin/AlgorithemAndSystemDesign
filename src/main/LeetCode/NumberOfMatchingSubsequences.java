package main.LeetCode;

public class NumberOfMatchingSubsequences {
    public int numMatchingSubseq(String S, String[] words) {
        int count = 0;
        if (words == null || words.length == 0 || S == null || S.length() == 0) {
            return count;
        }

        for (String s : words) {
            if (isSubsequence(S, s)) {
                count++;
            }
        }
        return count;
    }

    private boolean isSubsequence(String s, String p) {
        if (s.length() < p.length()) {
            return false;
        }
        int s1 = 0;
        int s2 = 0;
        while (s1 < s.length() && s2 < p.length()) {
            if (s.charAt(s1) == p.charAt(s2)) {
                s2++;
            }
            s1++;
        }
        return s2 == p.length();
    }
}
