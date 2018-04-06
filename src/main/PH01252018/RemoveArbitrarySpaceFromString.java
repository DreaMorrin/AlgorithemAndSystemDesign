package main.PH01252018;

public class RemoveArbitrarySpaceFromString {
	public static void main(String[] args) {
		RemoveArbitrarySpaceFromString rasfs = new RemoveArbitrarySpaceFromString();
		System.out.println(rasfs.solution(" a "));
	}
	
	public String solution(String s) {
		if(s == null || s.trim().length() == 0) {
			return s;
		}
		s = s.trim();
		char[] chars = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < chars.length - 1; i++) {
			sb.append(chars[i]);
			while (chars[i] == ' ' && chars[i] == chars[i+1]) {
				i++;
			}
		}
		return sb.append(chars[s.length()-1]).toString();
	}
}
