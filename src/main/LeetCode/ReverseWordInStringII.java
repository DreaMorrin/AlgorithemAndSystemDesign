package main.LeetCode;

public class ReverseWordInStringII {
    public void reverseWords(char[] str) {
        if (str == null || str.length < 2) {
            return;
        }
        int lens = str.length - 1;
        for (int i = 0; i <= lens / 2; i++) {
            char c = str[i];
            str[i] = str[lens - i];
            str[lens - i] = c;
        }
        System.out.println(new String(str));
        int start = 0;
        for (int i = 0; i <= lens; i++) {
            if (str[i] == ' ') {
                reverse(str, start, i - 1);
                start = i + 1;
            }
        }
        reverse(str, start, lens);
    }

    private void reverse(char[] str, int start, int end) {
        while (start < end) {
            char c = str[start];
            str[start] = str[end];
            str[end] = c;
            start++;
            end--;
        }
    }
}
