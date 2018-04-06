package main.PH01252018;

import java.util.HashMap;
import java.util.Map;

public class URLShortenerHash {
	char[] base;
	Map<Integer, String> idToHash = new HashMap<>();
	Map<String, Integer> hashToId = new HashMap<>();
	
	public URLShortenerHash() {
		base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		URLShortenerHash shortener = new URLShortenerHash();
		int id = 1232445677;
		String shortedId = shortener.idToShort(id);
		if (shortener.hashToId.containsKey(shortedId)) {
			
		} else {
			shortener.idToHash.put(id, shortedId);
			shortener.hashToId.put(shortedId, id);
		}
		System.out.println();
	}
	
	public String idToShort(int n) {
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			sb.append(base[n % 62]);
			n = n / 62;
		}
		return sb.toString();
	}

}
