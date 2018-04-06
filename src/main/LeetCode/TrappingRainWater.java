package main.LeetCode;

public class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int lens = height.length;
        int[] values1 = new int[lens];
        int[] values2 = new int[lens];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < lens; i++) {
            max = Math.max(height[i], max);
            values1[i] = max;
        }

        max = Integer.MIN_VALUE;
        for (int i = lens - 1; i >= 0; i--) {
            max = Math.max(height[i], max);
            values2[i] = max;
        }

        for (int i = 0; i < lens; i++) {
            values1[i] = Math.min(values1[i], values2[i]);
        }

        int volume = 0;
        for (int i = 0; i < lens; i++) {
            volume += values1[i] - height[i];
        }
        return volume;
    }
}
