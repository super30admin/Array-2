// Time Complexity : O(n) single iteration over all elements
// Space Complexity : O(1) no external data structure used for computation
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class FindMinMaxInArray {
	static int[] minMaxInArray(int[] nums) {
		//null check
		if(nums.length == 0 || nums == null) return new int[]{0,0};

		int[] result = new int[2]; //initializing the result array
		int min = 0, max = 0; //initializing the min max
		int i; //going to use for iteration

		if(nums.length % 2 == 0) { //if the number of elements is even
			if(nums[0] > nums[1]) { //comparing first two and storing min and max
				min = nums[1];
				max = nums[0];
			}
			else {
				min = nums[0];
				max = nums[1];
			}
			i = 2; //since the number of elements is even start from 2nd index
		}
		else { //if number of elements are odd
			min = nums[0];
			max = nums[0];
			i = 1; //since the number of elements is odd start from 1st index
		}

		result[0] = min;
		result[1] = max;

		while( i < nums.length ) {
			if( nums[i] > nums[i+1] ) {
				//max = Math.max( max, nums[i] );
				//min = Math.min( min, nums[i+1] );
				if( min > nums[i+1] ) {
					min = nums[i+1];
				}
				if(max < nums[i]) {
					max = nums[i];
				}
			}
			else {
				//max = Math.max( max, nums[i+1] );
				//min = Math.max( min, nums[i] );
				if(min > nums[i]) {
                    min = nums[i];
                }
                if(max < nums[i+1]) {
                    max = nums[i+1];
				}
			} 

			i = i + 2; //incrementing by 2 to take 2 elements in each iteration
			result[0] = min;
			result[1] = max;
		}
		return result;
	}
	
	public static void main(String args[]) {
			int[] input = new int[]{3, 7, 4, -1, 2, 6, -9, 1};
			
			int[] output = minMaxInArray( input );
			System.out.println("OUTPUTARRAY "+output[0]+" "+output[1]);
		}
}


