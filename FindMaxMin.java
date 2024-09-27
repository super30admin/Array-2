// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Not there on Leetcode
// Any problem you faced while coding this : No

public class FindMaxMin {
	public static void main(String[] args) {
		int[] arr = {4, 3, 2, 1, 70, 13, 14};
		int max = arr[0];
		int min = arr[0];
		
		for(int i = 1; i < arr.length; i++) {
			if(i == arr.length - 1) {
				max = Math.max(max, arr[i]);
				min = Math.min(min, arr[i]);
			} else if(arr[i] > arr[i + 1]) {
				max = Math.max(max, arr[i]);
				min = Math.min(min, arr[i + 1]);
			} else {
				max = Math.max(max, arr[i + 1]);
				min = Math.min(min, arr[i]);
			}
		}
		System.out.println("Max: " + max + ", Min: " + min);
	}
}
