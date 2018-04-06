package main.PH01252018;

public class CountChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountChar cc = new CountChar();
		System.out.println(cc.countChar("a"));
	}
	
	public String countChar(String s) {
		if (s == null || s.length() == 0) return s;

		String base = "";
		int start = 0;
		int count = 1;
		while (start < s.length()) {
			if (start == 0) {
				base += s.charAt(start);
			} else if (s.charAt(start) == s.charAt(start - 1)) {
				count++;
			} else {
				base = base + count + s.charAt(start);
				count = 1;
			}
			start++;
		}
		base += count;
		
		return base;
	}

}
