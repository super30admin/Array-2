// Time Complexity :
// Space Complexity : O(1)
// Did this code successfully run on GeeksForGeeks : Yes
// Any problem you faced while coding this : Faced difficulty calculating the Time complexity

public class MaxAndMin {

	static class Pair {
		int min;
		int max;
	}
	
	public static Pair getMinMax (int nums [], int n) {
		
		Pair minMax = new Pair();
		int i = 0;
		
		if(n % 2 == 0) {
			if(nums[0] < nums[1]) {
				minMax.min = nums[0];
				minMax.max = nums[1];
			} else {
				minMax.min = nums[1];
				minMax.max = nums[0];
			}
			i = 2;	
		} else {
			i = 1;
			minMax.min = nums[0];
			minMax.max = nums[0];
		}
		
		for( ;i< n-1; i=i+2) {
			if(nums[i] < nums[i+1]) {
				minMax.min = Math.min(minMax.min, nums[i]);
				minMax.max = Math.max(minMax.max, nums[i+1]);
			} else {
				minMax.min = Math.min(minMax.min, nums[i+1]);
				minMax.max = Math.max(minMax.max, nums[i]);
			}
		}
		
		return minMax;
	}
	
	public static void main(String args[]) {
        int [] nums = {10, 3, 7, 14, 8, 12, 9, 2, 11};
        Pair minmax = getMinMax(nums, nums.length);
        
        System.out.println("Minimum element is" +minmax.min);
        System.out.println("Maximum element is"+minmax.max);
    }
}
