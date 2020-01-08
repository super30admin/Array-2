// Time Complexity : 
//      findMinMax() - O(n)
//      
// Space Complexity :
//      findMinMax() - O(1)
//
// Number of Comparisons: 3(N-2)/2 + 2	which is less than 2*(N-2) comparisons
//
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
	
	public static void findMinMax(int[] arr)
	{
		int l = arr.length;

		int mmin = arr[0];
		int mmax = arr[0];

		for(int i=1; i < l-1; i = i + 2)
		{
			if(arr[i] < arr[i+1])
			{
				mmin = Math.min(arr[i], mmin);
				mmax = Math.max(arr[i+1], mmax);
			}
			else
			{
				mmin = Math.min(arr[i+1], mmin);
				mmax = Math.max(arr[i], mmax);
			}
		}

		mmin = Math.min(mmin, arr[l-1]);
		mmax = Math.max(mmax, arr[l-1]);

		System.out.println("min: " + mmin);
		System.out.println("max: " + mmax);
	}

	public static void main(String[] args)
	{
		int[] arr = new int[]{2,5,7,4,10,6,-3,2};
		findMinMax(arr);
	}
}