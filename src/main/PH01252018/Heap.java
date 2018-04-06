package main.PH01252018;

public class Heap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] initArray = new int[]{1,4,2,5,3,9,11,13,7,0};
		Heap heap = new Heap();
		
		heap.heapSort(initArray, 10);
		for(int num : initArray) {
			System.out.println(num);
		}
	}
	
	private void heapify(int[] nums, int n, int i) {
		int largest = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		
		if (l < n && nums[l] > nums[largest]) {
			largest = l;
		}
		
		if (r < n && nums[r] > nums[largest]) {
			largest = r;
		}
		
		if (largest != i) {
			int tmp = nums[largest];
			nums[largest] = nums[i];
			nums[i] = tmp;
			this.heapify(nums, n, largest);
		}
	}
	
	public void heapSort(int[] nums, int end) {
		int n = end;
		int beginIndex = (n / 2) - 1;
		for (int i = beginIndex; i >= 0; i--) {
			this.heapify(nums, n, i);
		}
		
		for (int i = n - 1; i >= 0; i--) {
			int tmp = nums[0];
			nums[0] = nums[i];
			nums[i] = tmp;
			heapify(nums, i, 0);
		}
	}
	
	

}
