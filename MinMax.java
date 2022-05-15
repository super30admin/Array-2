//minmax.java
// Time Complexity :O(n/2) 
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
public static int[] minmax(int[] nums){
		int max=Integer.MIN_VALUE;
		int min=Integer.MAX_VALUE;
		for(int i=0;i<nums.length && i+1!=nums.length;i=i+2)
		{
			if(nums[i]<nums[i+1]){
				min=Math.min(nums[i],min);
				max=Math.max(nums[i+1],max);
			}
			else{
				min=Math.min(nums[i+1],min);
				max=Math.max(nums[i],max);
			}
		}
		if(nums.length%2!=0){
			min=Math.min(nums[nums.length-1],min);
			max=Math.max(nums[nums.length-1],max);
		}
		return new int[]{min,max};

	}
