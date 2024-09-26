// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this : Referenced a solution


// Your code here along with comments explaining your approach

public void minMax(int[] nums){
	int min = 0, max = 0;
	
	if(nums == null||nums.length == null){
		return;
	}
	
	if(nums.length == 1){
		min = nums[0];
		max = nums[0];
		System.out.println("min:" + min + " max": + max);
		return;
	}
	
	if(nums[0] > nums[1]){
		min = nums[1];
		max = nums[0];
	}else{
		max = nums[1];
		min = nums[0];
	}
	
	for(int i = 2;i < nums.length; i++){
		if(max < nums[i]){
			max = nums[i];
		}else if(min > nums[i]){
			min = nums[i];
		}
	}
	
	System.out.println("min:" + min + " max": + max);
	
}