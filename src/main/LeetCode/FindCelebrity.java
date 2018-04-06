package main.LeetCode;

public class FindCelebrity {
    public int findCelebrity1(int n) {
        for (int i = 0, j = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (i != j && knows(i, j) || !knows(j, i)) {
                    break;
                }
            }
            if (j == n) {
                return i;
            }
        }
        return -1;
    }

    public int findCelebrity2(int n) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (knows(res, i)) res = i;
        }

        for (int i = 0; i < n; i++) {
            if (i != res && knows(res, i) || !knows(i, res)) {
                return -1;
            }
        }
        return res;
    }

    // Dummy method
    private boolean knows(int i, int j) {
        return true;
    }
}
