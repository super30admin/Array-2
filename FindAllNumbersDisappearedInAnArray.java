package array2;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
	//Time Complexity : O(n), where n is the length of array nums
	//Space Complexity : O(1)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : It was fairly easy doing with extra space, but O(1)
	//time was quite challenging
	public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        
        for(int i=0; i<nums.length; i++) {
            int curr = Math.abs(nums[i]);
            nums[curr - 1] *= nums[curr-1] > 0 ? -1: 1;
        }
        
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > 0)
                res.add(i + 1);
        }
        
        return res;
    }
}
