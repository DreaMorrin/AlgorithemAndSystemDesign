package main.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 Given an array of words and a length L, format the text such that each line has exactly L characters
 and is fully (left and right) justified.

 You should pack your words in a greedy approach; that is, pack as many words as you can in each line.
 Pad extra spaces ' ' when necessary so that each line has exactly L characters.

 Extra spaces between words should be distributed as evenly as possible.
 If the number of spaces on a line do not divide evenly between words,
 the empty slots on the left will be assigned more spaces than the slots on the right.

 For the last line of text, it should be left justified and no extra space is inserted between words.

 For example,
 words: ["This", "is", "an", "example", "of", "text", "justification."]
 L: 16.
 */
public class TextJustification {
    public static void main(String[] args) {

    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> lines = new ArrayList<>();
        int index = 0;
        if (words == null || words.length == 0) {
            return lines;
        }
        while (index < words.length) {
            int last = index + 1;
            int count = words[index].length(); // missed on space, so that the while needs plus 1
            while (last < words.length) {
                if (words[last].length() + count + 1 > maxWidth) {
                    break;
                }
                count += words[last].length() + 1;
                last++;
            }

            StringBuilder sb = new StringBuilder();
            int diff = last - 1 - index;
            //left align, last line
            if (last == words.length || diff == 0) {
                for (int i = index; i < last; i++) {
                    sb.append(words[i]).append(" ");
                }
                sb.deleteCharAt(sb.length() - 1);
                for (int i = count; i < maxWidth; i++) {
                    sb.append(" ");
                }
            } else {
                int spaces = (maxWidth - count) / diff;
                int adjust = (maxWidth - count) % diff;
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i < last - 1) {
                        for (int j = 0; j <= (spaces + (i - index < adjust ? 1 : 0)); j++) {
                            sb.append(" ");
                        }
                    }
                }
            }
            lines.add(sb.toString());
            index = last;
        }
        return lines;
    }
}
