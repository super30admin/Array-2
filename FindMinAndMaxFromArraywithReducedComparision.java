//Link to the problem --https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/

//approach B-f
//go element by element and check if that's less than what we have in in, then store in min. 
//also check for the same element, if that's greater than max?, i so add it to max. 
//it's going to be O(2n) comparision. 

public int[] findMinAndMax(int[] nums)
{
	
	if(nums == null || nums.length ==0) return new int[] {-1,-1};
	int n = nums.length;
	
	int min = nums[0];
	int max = nums[0];
	
	for(int i =0; i< n; i++)
	{
		min = Math.min(min, nums[0]);
		max = Math.max(max, nums[0]);
	}
	return new int[] {min, max};

}


//approach - optimized comparisions
//take a pair of 2 numbers, nums[i-1] and nums[i], and whatever is greater compare with max, and lesser value with min. 
//so, for n values, n/2 pairs, we have one comparision for nums[i-1] and nums[i], and then 2 comparision for min and max in total. 
//3*(n/2) == 1.5 n comparisions. - reduced then what we had in earlier approach 


public int[] findMinAndMax(int[] nums)
{
	
	if(nums == null || nums.length ==0) return new int[] {-1,-1};
	int n = nums.length;
	
	int min = nums[0];
	int max = nums[0];
	
	for(int i =1; i< n; i++)
	{
		if(nums[i-1] > nums[i])
		{
			max = Math.max(max, nums[i-1]);
			min = Math.min(min, nums[i]);
		}
		else //nums[i-1] <= nums[i]
		{
			max = Math.max(max, nums[i]);
			min = Math.min(min, nums[i-1]);
		}
		i++;
	}
	return new int[] {min, max};

}