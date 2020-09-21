import java.util.ArrayList;
import java.util.List;

public class MaxMinArray {
	
	public static void main(String[] args) {
		int[] nums = {5, 2, 4, 7, 1, 6};
		System.out.println(findMaxMin(nums));
	}
	/**
	 * Time: O(n)
	 * Space: O(1)
	 */
	private static List<Integer> findMaxMin(int[] nums) {
		List<Integer> result = new ArrayList<Integer>();
		int max = nums[0], min = nums[0];
		int hi, lo;
		for(int i=1; i<nums.length; i+=2) {
			//For even length array, since one element is already used for comparison in the beginning,
			// last element will be left out
			if(i == nums.length -1) {
				max = Math.max(nums[i], max);
				min = Math.min(nums[i], min);
			} else {
				if(nums[i] > nums[i+1]) {
					hi = nums[i];
					lo = nums[i+1];
				} else {
					hi = nums[i+1];
					lo = nums[i];
				}
				max = Math.max(hi, max);
				min = Math.min(lo, min);
			}
		}
		result.add(min);
		result.add(max);
		return result;
	}

}
