package main.PH01252018;

public class FindDupAndMissing {
	public static void main(String[] args) {
		FindDupAndMissing obj = new FindDupAndMissing();
		int[] nums = new int[]{3,3,5,1,4};
		System.out.println(obj.findDup(nums));
	}
	
	public int findDup(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] - 1 != i && nums[nums[i]-1] != nums[i]) {
				int temp = nums[i];
				nums[i] = nums[temp - 1];
				nums[temp - 1] = temp;
			} else if (nums[nums[i]-1] == nums[i]) {
				return nums[i] - 1;
			}
		}
		return -1;
	}
}
