package main.PH01252018;

import java.util.ArrayList;
import java.util.List;

public class SubSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubSet ss = new SubSet();
		int[] nums = new int[]{1,2,3,4};
		for (List<Integer> list : ss.subset(nums)) {
			System.out.println();
			System.out.print("[");
			for (int i : list) {
				System.out.print(i);
				System.out.print(",");
			}
			System.out.print("]");
			System.out.println();
		}
	}
	
	public List<List<Integer>> subset(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		int total = 1 << nums.length;
		for (int i = 0; i < total; i++) {
			List<Integer> list = new ArrayList<>();
			for (int j = 0; j < nums.length; j++) {
				if((i & (1 << j)) != 0) {
					list.add(nums[j]);
				}
			}
			result.add(list);
		}
		return result;
	}

}
