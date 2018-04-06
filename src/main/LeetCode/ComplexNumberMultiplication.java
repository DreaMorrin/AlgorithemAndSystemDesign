package main.LeetCode;

/**
 * 537. Complex Number Multiplication
 *
 Given two strings representing two complex numbers.

 You need to return a string representing their multiplication. Note i2 = -1 according to the definition.

 Example 1:
 Input: "1+1i", "1+1i"
 Output: "0+2i"
 Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
 Example 2:
 Input: "1+-1i", "1+-1i"
 Output: "0+-2i"
 Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
 Note:

 The input strings will not have extra blank.
 The input strings will be given in the form of a+bi, where the integer a and b will both belong to the range of [-100, 100]. And the output should be also in this form.
 */

public class ComplexNumberMultiplication {
    public String complexNumberMultiply(String a, String b) {
        String[] ac = a.split("\\+");
        String[] bc = b.split("\\+");
        int ar = Integer.parseInt(ac[0]);
        int br = Integer.parseInt(bc[0]);
        int ai = Integer.parseInt(ac[1].substring(0, ac[1].length() - 1));
        int bi = Integer.parseInt(bc[1].substring(0, bc[1].length() - 1));

        int nr = ar * br;
        int nrc = ar * bi + ai * br;
        int nc = ai * bi;
        String r = nr - nc + "";
        String c = nrc + "i";
        return r + "+" + c;
    }
}
