package main.PH01252018;

public class ReverseWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseWord rw = new ReverseWord();
//		System.out.println(rw.reverseWord("abcba"));
		String str = "abchdns";
		StringBuilder sb = new StringBuilder();
		System.out.println(rw.recursive(str, sb, 0));
		
	}
	
	public String reverseWord(String s) {
		if (s == null || s.length() < 2) {
			return s;
		}
		
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length / 2; i++) {
			char c = chars[i];
			chars[i] = chars[chars.length - 1 -i];
			chars[chars.length - 1 -i] = c;
		}
		
		return new String(chars);
	}
	
	public StringBuilder recursive(String s, StringBuilder sb, int i) {
		if (i == s.length()) {
			return sb;
		}
		StringBuilder nSb = new StringBuilder();
		nSb.append(s.charAt(i)).append(sb);
		return recursive(s, nSb, i+1);
	}
}
