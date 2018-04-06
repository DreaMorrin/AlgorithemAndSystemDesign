package main.Practice.OODesign;

import java.util.Arrays;

public class BigInteger {

    // The sign of this integer - true for a positive number, and false
    // otherwise
    private boolean sign = true;

    // digits[0] is the most significant digit of the integer, and
    // the last element of this array is the least significant digit.
    // For example, if we have a BigInteger of value 34, then
    // digits[0] = 3 and digits[1] = 4.
    private int[] digits;

    public BigInteger() {
        this.digits = new int[1];
        this.digits[0] = 0;
    }

    public BigInteger(int[] digits) {
        this.digits = digits;
    }

    /**
     * Initializes a <code>BigInteger</code> according to a string. The form of
     * <code>numberStr</code> is a string consisting of all digits ranging from
     * 0 to 9, following an OPTIONAL minus symbol (i.e., "-"). For example,
     * "1234567891234567" and "-17788399934334388347734" are both valid.
     *
     * @param numberStr
     *            a number expressed as a string
     */
    public BigInteger(String numberStr) {
        this();
        if (numberStr != null && numberStr.length() > 0) {
            if (numberStr.charAt(0) == '-') {
                sign = false;
            }
            char[] chars = numberStr.toCharArray();
            int lens = sign ? numberStr.length() : numberStr.length() - 1;
            int startIndex = sign ? 0 : 1;
            digits = new int[lens];
            int index = 0;
            for (int i = startIndex; i < chars.length; i++) {
                digits[index] = (chars[i] - '0');
                index++;
            }
        }


    }

    /**
     * Performs addition.
     *
     * @param another
     *            another <code>BigInteger</code> object
     * @return this+another
     */
    public BigInteger add(BigInteger another) {
        // YOU FILL THIS IN
//        if (sign ^ another.sign) {
//            return this;
//        } else {
            int end1 = this.digits.length - 1;
            int end2 = another.digits.length - 1;
            boolean mergeToEnd1 = true;
            if (this.digits.length < another.digits.length) {
                mergeToEnd1 = false;
            }
            int carry = 0;
            while (end1 >= 0 && end2 >= 0) {
                int total = digits[end1] + another.digits[end2] + carry;
                carry = total / 10;
                int sum = total % 10;
                if (mergeToEnd1) {
                    this.digits[end1] = sum;
                    end1--;
                    end2--;
                } else {
                    another.digits[end2] = sum;
                    end1--;
                    end2--;
                }
            }

            if (end1 >= 0) {
                while (end1 >= 0 && carry > 0) {
                    int total = this.digits[end1] + carry;
                    carry = total / 10;
                    int sum = total % 10;
                    this.digits[end1] = sum;
                    end1--;
                }
            }

            if (end2 >= 0) {
                while (end2 >= 0 && carry > 0) {
                    int total = another.digits[end2] + carry;
                    carry = total / 10;
                    int sum = total % 10;
                    another.digits[end2] = sum;
                    end2--;
                }
            }
            return mergeToEnd1 ? this : another;
//        }
    }


//    public BigInteger add(int num) {
//        // YOU FILL THIS IN
//    }
//
//    /**
//     * Performs subtraction.
//     *
//     * @param another
//     *            another <code>BigInteger</code> object
//     * @return this-another
//     */
//    public BigInteger subtract(BigInteger another) {
//        // YOU FILL THIS IN
//    }
//
//    /**
//     * Performs subtraction.
//     *
//     * @param num
//     *            an integer
//     * @return this-num
//     */
//    public BigInteger subtract(int num) {
//        // YOU FILL THIS IN
//    }
//
//    /**
//     * Performs multiplication.
//     *
//     * @param another
//     *            another <code>BigInteger</code> object
//     * @return this*another
//     */
//    public BigInteger multiply(BigInteger another) {
//        // YOU FILL THIS IN
//    }
//
//    /**
//     * Performs multiplication.
//     *
//     * @param num
//     *            an integer
//     * @return this*num
//     */
//    public BigInteger multiply(int num) {
//        // YOU FILL THIS IN
//    }

    public String toString() {
        StringBuffer buf = new StringBuffer();
        if (!sign) {
            buf.append("-");
        }
        for (int d : digits) {
            buf.append(d);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        BigInteger i1 = new BigInteger("222222222222222222222222");
        BigInteger i2 = new BigInteger("555555555555555");
        BigInteger i3 = i1.add(i2);
        System.out.println(Arrays.toString(i3.digits));
//        System.out.println(i2); // the output should be 1000000000000000000
//        BigInteger i3 = i2.multiply(i1);
//        System.out.println(i3); // expected: 999999999999999999000000000000000000
//        System.out.println(i3.subtract(-3)); // expected: 999999999999999999000000000000000003
    }
}