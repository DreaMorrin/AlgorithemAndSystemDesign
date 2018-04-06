package main.LeetCode;

/**
 * 204. Count Primes
 * Description:
 * Count the number of prime numbers less than a non-negative number, n.
 */

public class CountPrimes {
    public int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }
        int count = 0;
        boolean[] notPrime = new boolean[n];
        notPrime[0] = true;
        notPrime[1] = true;
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (!notPrime[i]) {
                for (int j = 2; i * j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }

        for (int i = 0; i < notPrime.length; i++) {
            if (!notPrime[i]) {
                count++;
            }
        }
        return count;
    }
}
