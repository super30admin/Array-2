// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

public class FindMinMax {

	public static int[] findMinMax(int[] nums) {
		if(nums==null || nums.length ==0) return new int[0];
		
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		
		int n = nums.length;
		int limit = (n%2 ==0) ? n -1 : n - 2;
		
		/*
		 * to reduce comparisons, compare pairs,
		 * compare smaller with min, larger with max
		 * in simple method, we compare each number twice,
		 * here we compare 2 numbers 3 times instead of 4
		 * total comparisons --> 2n-(n/2)
		 */
		for(int i=0; i < limit; i=i+2) {
			int a = nums[i];
			int b = nums[i+1];
			
			if(a<b) {
				if(a < min) {
					min = a;
				}
				if(b > max) {
					max = b;
				}
			} else {
				if(b<min) {
					min = b;
				}
				if(a>max) {
					max = a;
				}
			}
		}
		
		//if odd length array, one element is left without pair, compare that
		if(n%2 !=0) {
			if(nums[n-1] < min) {
				min = nums[n-1];
			}else if(nums[n-1] > max) {
				max = nums[n-1];
			}
		}
		
		System.out.println(min + " " + max);
		int[] res = {min, max};
		return res;
	}
	
	public static void main(String[] args) {
		
		int[] a = {2,1,6,3,-1};
		findMinMax(a);
	}
}
