package main.Practice.Algorithm.亚麻20150228;

import java.util.ArrayList;
import java.util.List;

public class FindNPrimeNumbers {
    public static void main(String[] args) {
        FindNPrimeNumbers f = new FindNPrimeNumbers();
        for (int i : f.findPrimesLessThanN(40)) {
            System.out.println(i);
        }
        f.findNPrimes(12).stream().forEach(i -> System.out.println(i));
    }

    public List<Integer> findPrimesLessThanN(int n) {
        List<Integer> list = new ArrayList<>();
        if (n < 2) {
            return list;
        }
        boolean[] notPrime = new boolean[n];
        notPrime[0] = true;
        notPrime[1] = true;
        for (int i = 2; i < Math.sqrt(n); i++) {
            for (int j = 2; i * j < n; j++) {
                notPrime[i * j] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            if (!notPrime[i]) {
                list.add(i);
            }
        }
        return list;
    }

    public List<Integer> findNPrimes(int n) {
        List<Integer> list = new ArrayList<>();
        if (n == 0) {
            return list;
        }

        int start = 2;
        while (list.size() != n) {
            if (isPrime(start)) {
                list.add(start);
            }
            start++;
        }
        return list;
    }

    private boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num != 2 && num % i == 0 ) {
                return false;
            }
        }
        return true;
    }
}
