package test;

import main.Practice.Algorithm.CheckIsConsecutiveArray;
import org.junit.jupiter.api.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CheckIsConsecutiveArrayTest {
    @Test
    public void testCase1() {
        int[] testArray = new int[]{1,5,2,0,3,6,7,9,8,0};
        CheckIsConsecutiveArray obj = new CheckIsConsecutiveArray();
        assertTrue(obj.isConsecutiveArray(testArray));
    }

    @Test
    public void testCase2() {
        int[] testArray = new int[]{1,5,2,0,3,6,7,11,8,0};
        CheckIsConsecutiveArray obj = new CheckIsConsecutiveArray();
        assertFalse(obj.isConsecutiveArray(testArray));
    }

    @Test
    public void testCase3() {
        int[] testArray = new int[]{0,0,0,0,0,0,0,0,0,0,0};
        CheckIsConsecutiveArray obj = new CheckIsConsecutiveArray();
        assertTrue(obj.isConsecutiveArray(testArray));
    }
}
