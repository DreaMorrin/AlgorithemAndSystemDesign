package main.Practice.Algorithm.亚麻20161214;

/**
 * 273. Integer to English Words
 Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

 For example,
 123 -> "One Hundred Twenty Three"
 12345 -> "Twelve Thousand Three Hundred Forty Five"
 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"

 */
public class IntegerToEnglishWords {
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        String[] lessThan20Words = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tyWords = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] dexWords = {"Billion", "Million", "Thousand", "Hundred"};
        int[] radix = new int[]{1000000000, 1000000, 1000, 100};
        StringBuilder sb = new StringBuilder();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < radix.length; i++) {
            int count = num / radix[i];
            if (count == 0) {
                continue;
            }
            sb.append(numberToWords(count) + " ");
            sb.append(dexWords[i] + " ");
            num = num % radix[i];
        }

        if (num < 20) {
            sb.append(lessThan20Words[num]);
        } else {
            sb.append(tyWords[num / 10 - 2] + " ");
            sb.append(lessThan20Words[num % 10]);
        }
        return sb.toString().trim();
    }
}
