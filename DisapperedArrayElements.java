// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes

// Approach
//1) use the index of the array to mark the appearance of the number
//2) Now, loop again and indexes with non negative values did not appear

import java.util.ArrayList;
import java.util.List;

public class DisapperedArrayElements {
	
	public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] = - nums[Math.abs(nums[i]) - 1];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                results.add(i + 1);
            }
        }
        return results;
	}

	public static void main(String[] args) {
		DisapperedArrayElements obj = new DisapperedArrayElements();
		int[] arr = {4,3,2,7,8,2,3,1};
		List<Integer> results = obj.findDisappearedNumbers(arr);
		System.out.println(results.size());
	}
}
