package main.PH01252018;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Route {
	private static Map<String, List<String>> map = new HashMap<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list1 = new ArrayList<>();
		list1.add("C");
		list1.add("D");
		list1.add("B");
		
		List<String> list2 = new ArrayList<>();
		list2.add("A");
		
		List<String> list3 = new ArrayList<>();
		list3.add("A");
		list3.add("D");
		
		List<String> list4 = new ArrayList<>();
		list4.add("A");
		list4.add("C");
		
		map.put("A", list1);
		map.put("B", list2);
		map.put("C", list3);
		map.put("D", list4);
		
		Route route = new Route();
		route.addRoute("A", "E");
		route.addRoute("D", "E");
		List<List<String>> results = route.printAll("F", "E");
		
		for (List<String> list: results) {
			System.out.println("*****");
			for (String s : list) {
				System.out.print(s + "\t");
			}
			System.out.println();
		}
		
	}

	public void addRoute(String A, String B) {
		if (map.containsKey(A)) {
			map.get(A).add(B);
		} else {
			List<String> nList = new ArrayList<>();
			nList.add(B);
			map.put(A, nList);
		}
	}
	
	public List<List<String>> printAll(String A, String B) {
		List<List<String>> results = new ArrayList<>();
		if(A.equals(B)) {
			return results;
		}
		List<String> initList = new ArrayList<>();
		initList.add(A);
		helper(results, initList, A, B);
		return results;
	}
	
	private void helper(List<List<String>> results, List<String> list, String A, String B) {
		if(A.equals(B)) {
			results.add(new ArrayList<String>(list));
			return;
		}
		if (map.containsKey(A)) {
			for (String s : map.get(A)) {
				if (list.contains(s)) {
					continue;
				}
				list.add(s);
				helper(results, list, s, B);
				list.remove(list.size() - 1);
			}
		}
	}
}
