package main.Practice.Algorithm.亚麻20141210;

import java.util.List;

/**
 * 139. Word Break
 *
 Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.

 For example, given
 s = "leetcode",
 dict = ["leet", "code"].

 Return true because "leetcode" can be segmented as "leet code".

 UPDATE (2017/1/4):
 The wordDict parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.


 */

public class WordBreakI {

    /**
     * wordBreakTopDown
     */
    public boolean wordBreakTopDown(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j <= n; j++) {
                if (dp[j] && wordDict.contains(s.substring(i, j))) {
                    dp[i] = true;
                }
            }
        }
        return dp[0];
    }

    /**
     * wordBreakBottomUp
     */
    public boolean wordBreakBottomUp(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[n];
    }
}
