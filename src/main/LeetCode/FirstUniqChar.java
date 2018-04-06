package main.LeetCode;

/**
 Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

 Examples:

 s = "leetcode"
 return 0.

 s = "loveleetcode",
 return 2.
 Note: You may assume the string contain only lowercase letters.


 */

public class FirstUniqChar {

    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }

        int[] hash = new int[26];
        int index = -1;
        for (char ch : s.toCharArray()) {
            hash[ch - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (hash[s.charAt(i) - 'a'] == 1) {
                index = i;
                break;
            }
        }
        return index;
    }
}

