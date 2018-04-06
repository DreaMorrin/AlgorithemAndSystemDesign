package test;

import main.Practice.Algorithm.亚麻20170910.CoinChange;
import org.junit.jupiter.api.Test;

import static org.testng.Assert.assertEquals;

public class CoinChangeTest {
    @Test
    public void testCase1() {
        CoinChange cc = new CoinChange();
        int[] coins = {1,8,10};
        int amount = 16;
        assertEquals(cc.coinChangeGreedy(coins, amount), 7);
    }

    @Test
    public void testCase2() {
        CoinChange cc = new CoinChange();
        int[] coins = {1,8,10};
        int amount = 16;
        assertEquals(cc.coinChange(coins, amount), 2);
    }
}
