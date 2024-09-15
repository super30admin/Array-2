// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

/*
Iterating each element in the array and changing the value to negative number
in the respective index. By doing so, I will get all the elements negated except which is not 
found in the array with corresponding to the index.

Iterating the array one more time where the numbers are positive.
The index gives the missing elements in the array.


*/

import java.util.*;

public class FindDisappearedNumbers {

	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> res = new ArrayList<>();
		
		int len = nums.length;
		for(int i=0; i<len; i++) {
			int n = Math.abs(nums[i]);
			if(nums[n-1]>0)
				nums[n-1] = nums[n-1] * (-1);		
		}
		
		for(int i=0; i<len; i++) {
			if(nums[i] > 0) {
				res.add(i+1);
			}
		}
		
		
		return res;
	}

	public static void main(String[] args) {
		int[] arr = { 4, 3, 2, 7, 8, 2, 3, 1 };
		
		
		FindDisappearedNumbers f = new FindDisappearedNumbers();
		List<Integer> res = f.findDisappearedNumbers(arr);
		
		for(int r: res) {
			System.out.println(r);
		}

	}

}
