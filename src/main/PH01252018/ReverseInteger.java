package main.PH01252018;

public class ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseInteger ri = new ReverseInteger();
		System.out.println(ri.reverse(1<<15));
	}

	public int reverse(int num) {
		int sign = 1;
		if (num < 0) {
			sign = -1;
		}
		num = Math.abs(num);
		int y = 0;
		while (num > 0) {
			int yy = y * 10 + num % 10;
			if (y != (yy - (num % 10)) / 10) {
				return 0;
			}
			y = yy;
			num = num / 10;
		}
		
		return y * sign;
	}
}
