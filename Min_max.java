
// TC: O(N) since we are traversin each element in the array
// SC: O(1) since we are not using any extra space.

// We are traversing the array and comparing elements if they are greater than present, then append that new max number to the max value.
// if they find element lesser than current minimum, store that in min value.
// FUNCTION LessComparison - we are comparing 2 elements at a time because of which we have reduced the comparisons and it is less than 2*(N-2).


public class Min_max {
	
	public void minMax(int[] nums) {
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]>max)
				max= nums[i];
			
			if(nums[i]<min)
				min = nums[i];
		}
		
		System.out.println(max+" "+min);
	}
	
	public void LessComparison(int[] nums) {
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE; 
		
		int i=0, n = nums.length;
		
		if(n%2==0) {
			if(nums[0]>nums[1])
			{
				max = nums[0];
				min = nums[1];
			}else {
				max = nums[1];
				min = nums[0];
			}
			i=2;
		}else {
			min = nums[0];
			max = nums[0];
			i=1;
		}
		while(i<n-1) {
			
			if(nums[i]>nums[i+1]) {
				if(nums[i]>max)
					max= nums[i];
				if(nums[i+1]<min)
					min = nums[i+1];
			}
			else {
				if(nums[i+1]>max)
					max = nums[i+1];
				if(nums[i]<min)
					min = nums[i];
			}
			
			i += 2;
		}
		System.out.println(max+" "+min);

	}
	
	public static void main(String[] args) {
		Min_max mm = new Min_max();
		
		int[] nums = {1,3, 5, -1, 8};
		
		mm.LessComparison(nums);
		mm.minMax(nums);
	}

}
