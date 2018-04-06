package test;

import main.Practice.Algorithm.亚麻20150122.CountNumsPresentedOddTimes;
import org.junit.jupiter.api.Test;

public class CountNumsPresentedOddTimesTest {
    @Test
    public void testCase1() {
        CountNumsPresentedOddTimes obj = new CountNumsPresentedOddTimes();
        int[] nums = new int[]{5,1,1,1,3,1,1,4,3,5,5,6,7,8,9,5,7,5,9};
        System.out.println(obj.getNumsPresentedOddTimes(nums));
    }
}
