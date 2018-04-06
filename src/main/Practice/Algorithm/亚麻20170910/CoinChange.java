package main.Practice.Algorithm.亚麻20170910;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }

        if (amount <= 0) {
            return 0;
        }

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] == i) {
                    dp[i] = 1;
                } else if ((i - coins[j] >= 0) && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    /**
     * Greedy wrong implementation
     */
    public int coinChangeGreedy(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }

        if (amount <= 0) {
            return 0;
        }

        int count = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            while (amount >= coins[i]) {
                amount -= coins[i];
                count++;
            }
        }
        return count;
    }
}
