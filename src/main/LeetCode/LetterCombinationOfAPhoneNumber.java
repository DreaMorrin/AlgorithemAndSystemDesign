package main.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 Given a digit string, return all possible letter combinations that the number could represent.

 A mapping of digit to letters (just like on the telephone buttons) is given below.



 Input:Digit string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 Note:
 Although the above answer is in lexicographical order, your answer could be in any order you want.


 */

public class LetterCombinationOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        String[] digitLetter = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> list = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return list;
        }
        list.add("");
        for (char ch : digits.toCharArray()) {
            list = addComb(digitLetter[ch - '0'], list);
        }
        return list;
    }

    private List<String> addComb(String digit, List<String> list) {
        if (digit.length() == 0) {
            return list;
        }
        List<String> solution = new ArrayList<>();
        for (int i = 0; i < digit.length(); i++) {
            for (String s : list) {
                solution.add(s + digit.charAt(i));
            }
        }
        return solution;
    }

}
