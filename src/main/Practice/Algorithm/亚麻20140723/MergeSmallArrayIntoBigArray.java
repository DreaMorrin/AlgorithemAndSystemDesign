package main.Practice.Algorithm.亚麻20140723;

public class MergeSmallArrayIntoBigArray {
    public void mergeTwoArrays(int[] a1, int[] a2, int alens) {
        if (a2 == null || a2.length == 0) {
            return;
        }

        int s1 = 0;
        int s2 = 0;
        while (s1 < alens) {
            s2 = s2 % a2.length;
            if (a1[s1] < a2[s2]) {
                s1++;
            } else {
                int temp = a1[s1];
                a1[s1] = a2[s2];
                a2[s2] = temp;
                s1++;
                s2++;
            }
        }
        s2 = 0;
        while (s2 < a2.length) {
            a1[s1] = a2[s2];
            s1++;
            s2++;
        }
    }
}
