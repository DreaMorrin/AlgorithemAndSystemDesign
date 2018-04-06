package main.LeetCode;

import java.util.Arrays;

/**
 * 135. Candy
 There are N children standing in a line. Each child is assigned a rating value.

 You are giving candies to these children subjected to the following requirements:

 Each child must have at least one candy.
 Children with a higher rating get more candies than their neighbors.
 What is the minimum candies you must give?
 */

public class Candy {
    public int candy(int[] ratings) {
        int count = 0;

        if (ratings == null || ratings.length == 0) {
            return count;
        }

        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = candies[i] > candies[i + 1] ? candies[i] : candies[i + 1] + 1;
            }
        }

        for (int i : candies) {
            count += i;
        }
        return count;
    }
}
