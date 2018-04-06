package main.PH01252018;

public class FindTarget {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindTarget ft = new FindTarget();
		int[] nums = new int[]{1,1,1,1,2,3,3,3,3,4,4,4,4,5,6,9,9,9,9};
		System.out.println(ft.findTarget(nums, 6));
	}
	
	public int findTarget(int[] nums,int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		
		int start = 0;
		int end = nums.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			System.out.println(mid);
			if (nums[mid] >= target) {
				end = mid;
			} else {
				start = mid;
			}
		}
		
		if (nums[start] == target) {
			return start;
		}
		if (nums[end] == target) {
			return end;
		}
		return -1;
	}

}
