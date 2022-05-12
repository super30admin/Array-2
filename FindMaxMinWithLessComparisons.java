/**
Time Complexity : O(N) N = input size
Space Complexity : O(1) = input size
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
**/
public class FindMaxMinWithLessComparisons
{
	
	private int[] findMinMaxBruteforce(int nums[])
	{
		int count = 0;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		int result[] = new int[3];

		for(int i = 0; i< nums.length; i++)
		{
			int current = nums[i];
			
			if(current > max)
				max = current;
			
			if(current < min)
				min = current;

			count += 2;
		}

		result[0] = min;
		result[1] = max;
		result[2] = count;

		return result;
	}

	private int[] findMinMaxOptimized(int nums[])
	{
		int count = 0;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		int result[] = new int[3];

		int start = 0;
		int end = nums.length -1;


		for(int i = 0; i< nums.length-1; i = i + 2)
		{

			if(nums[i] > nums[i+1])
			{
				max = Math.max(max, nums[i]);
				min = Math.min(min, nums[i+1]);
			}
			else
			{
				max = Math.max(max, nums[i+1]);
				min = Math.min(min, nums[i]);
			}
			
		}



		result[0] = min;
		result[1] = max;
		result[2] = (3 * (nums.length))/2;

		return result;
	}	
	
	public static void main(String argv[])
	{

		int input[] = new int[]{2,34,23,5,-5,6,11,33,6,78,-99,40};
		int inputSize = input.length;
		int maxAllowed = 2 * (inputSize-2);

		FindMaxMinWithLessComparisons find = new FindMaxMinWithLessComparisons();

		int result[] = find.findMinMaxBruteforce(input);
		System.out.printf("Normal Comparison Min: %d Max: %d Allowed: %d Count: %d\n", 
			result[0], result[1], maxAllowed, result[2]);

		result = find.findMinMaxOptimized(input);
		System.out.printf("Optimised Comparison Min: %d Max: %d Allowed: %d Count: %d\n", 
			result[0], result[1], maxAllowed, result[2]);

	}
}