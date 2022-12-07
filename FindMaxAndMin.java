import java.util.Arrays;

//Time Complexity :O(N)
//Space Complexity :O(1)  
//Did this code successfully run on Leetcode : N/A
//Any problem you faced while coding this :No 
public class FindMaxAndMin {

	public static int[] findMaxAndMin(int[] nums) {
		int result[] = new int[2];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int n = nums.length;
		int i=0;
		if(n%2==1) {
			while(i<n) {
				if(nums[i]>nums[i+1]) {	
					max = Math.max(max, nums[i]);
					min = Math.min(min, nums[i+1]);
				}	
			else {
				max = Math.max(max, nums[i+1]);
				min = Math.min(min, nums[i]);
				}
			i=i+2;
			 }
			
		}
		else {
			while(i<n-1) {
				if(nums[i]>nums[i+1]) {	
					max = Math.max(max, nums[i]);
					min = Math.min(min, nums[i+1]);
				}	
			else {
				max = Math.max(max, nums[i+1]);
				min = Math.min(min, nums[i]);
				}	
				i=i+2;
			 }
			
			min = Math.min(min, nums[n-1]);
			max = Math.max(max, nums[n-1]);
			
		}
		
		result[0] = min;
		result[1] = max;
		return result;
	}
	
	public static void main(String[] args) {
	
		int [] nums = {1,2,5,118,4,2,6,9,7,34,99,2};
		System.out.println(Arrays.toString(findMaxAndMin(nums)));
		
	}
}
