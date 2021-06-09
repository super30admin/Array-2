// Time Complexity : O(N) //N is the length of array. actually 2 O(N) but constant neglected
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


/**
 * 1. loop through array and related number index value mark it as negative.
 * 2. get the indexes which has positive numbers that are missing numbers. 
 */

import java.util.ArrayList;
import java.util.List;

public class DisappearedinanArray {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> result = new ArrayList<>(nums.length);
		
		for(int i=0;i<nums.length;i++) {
			int index = Math.abs(nums[i])-1; // as array values starts from 1
			if(nums[index]>0)
				nums[index] *= -1;
		}
		
		for(int i=0;i<nums.length;i++) {
			if(nums[i]>0) {
				result.add(i+1);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {1,1};
		System.out.println(new DisappearedinanArray().findDisappearedNumbers(arr));
	}
}
