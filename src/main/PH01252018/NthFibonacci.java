package main.PH01252018;

public class NthFibonacci {
	public static void main(String[] args) {
		NthFibonacci nf = new NthFibonacci();
		System.out.println(nf.nthFibonacci(6));
	}
	
	public int nthFibonacci(int n) {
		int init1 = 0;
		int init2 = 1;
		for (int i = 2; i <= n; i++) {
			int temp = init2;
			init2 = init1 + init2;
			init1 = temp;
		}
		
		return n < 2 ? n : init2;
	}
}
