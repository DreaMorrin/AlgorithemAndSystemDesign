package test;

import main.LeetCode.GasStation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GasStationTest {
    @Test
    public void generalTest1() {
        GasStation gs = new GasStation();
        int[] gas = new int[]{2, 3, 5, 1, 1};
        int[] cost = new int[]{1, 2, 7, 0, 2};
        assertEquals(gs.canCompleteCircuit(gas, cost), 0, "Car should start at index 0");
    }

    @Test
    public void generalTest2() {
        GasStation gs = new GasStation();
        int[] gas = new int[]{2, 3, 5, 1, 3};
        int[] cost = new int[]{1, 1, 6, 4, 1};
        assertEquals(gs.canCompleteCircuit(gas, cost), 4, "Car should start at index 4.");
    }

    @Test
    public void nullTest() {
        GasStation gs = new GasStation();
        assertEquals(gs.canCompleteCircuit(null, null), -1, "Should return -1");
        assertEquals(gs.canCompleteCircuit(new int[0], null), -1, "Should return -1");
        assertEquals(gs.canCompleteCircuit(null, new int[0]), -1, "Should return -1");
    }
}
