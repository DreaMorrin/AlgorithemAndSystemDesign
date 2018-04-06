package main.PH01252018;

import java.util.ArrayList;
import java.util.List;

public class CountPrimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountPrimes cp = new CountPrimes();
		for (int num : cp.getPrimes(20)) {
			System.out.println(num);
		}
		
	}
	
	public List<Integer> getPrimes(int n) {
		List<Integer> list = new ArrayList<>();
		boolean[] notPrime = new boolean[n];
		int res = 0;
		for (int i = 2; i < n; i++) {
			if (!notPrime[i]) {
				list.add(i);
				res++;
				for (int j = 2; i * j < n; j++) {
					notPrime[i * j] = true;
				}
			}
		}
		return list;
	}

}
