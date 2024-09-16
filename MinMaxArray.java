// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Did not find it in leetcode
// Any problem you faced while coding this : No

// Approach
// 1) Initialize values of min and max as minimum and maximum of the first two elements 
// 2) Loop through 2 element through end of array and compare each element with max and min and then change accordingly.
public class MinMaxArray {
	
	public int[] minmax(int[] nums) {
		if(nums == null || nums.length == 0)return new int[0];
		int[] result = new int[2];
		int min;int max;
		if(nums.length == 1) {
			result[0] = nums[0];
			result[1] = nums[0];
			return result;
		}else {
			if(nums[0] > nums[1]) {
				min = nums[0]; max = nums[1];
			}else {
				max = nums[0];min = nums[1];
			}
			for(int i =2;i<nums.length; i++) {
				if(max < nums[i]) {
					max = nums[i];
				}
				if(min > nums[i]) {
					min = nums[i];
				}
			}
		}
		result[0] = min; result[1] = max;
		return result;
	}
	
	public static void main(String[] args) {
		MinMaxArray obj = new MinMaxArray();
		int[] arr = {4,3,2,7,8,2,3,1};
		int[] result = obj.minmax(arr);
		
		System.out.println( "min : "+result[0]+ " and max: "+result[1]);
	}
}
