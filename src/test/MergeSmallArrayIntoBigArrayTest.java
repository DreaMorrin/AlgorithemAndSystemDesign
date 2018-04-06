package test;

import main.Practice.Algorithm.亚麻20140723.MergeSmallArrayIntoBigArray;
import org.junit.jupiter.api.Test;

import static org.testng.Assert.assertEquals;

public class MergeSmallArrayIntoBigArrayTest {
    @Test
    public void testCase1() {
        MergeSmallArrayIntoBigArray obj = new MergeSmallArrayIntoBigArray();
        int[] a1 = new int[]{1,2,5,6,7,8,0,0};
        int[] a2 = new int[]{3,4};

        obj.mergeTwoArrays(a1, a2, 6);

        int[] expected = new int[]{1,2,3,4,5,6,7,8};
        assertEquals(a1, expected);
    }
}
