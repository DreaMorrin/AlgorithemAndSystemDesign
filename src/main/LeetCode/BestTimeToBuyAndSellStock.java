package main.LeetCode;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int lens = prices.length;
        int[] dp = new int[lens];
        dp[0] = 0;
        int min = prices[0];

        for (int i = 1; i < lens; i++) {
            if (dp[i - 1] == 0) {
                dp[i] = prices[i] > min ? prices[i] - min : 0;
            } else {
                dp[i] = prices[i] - min > dp[i - 1] ? prices[i] - min : dp[i - 1];
            }
            min = Math.min(min, prices[i]);
        }
        return dp[lens - 1];
    }
}
