package day11_Array2;

import java.util.ArrayList;
import java.util.List;
// Idea : 1. We iterate over the array till last element and make the values negative.
//        2. In the next iteration, we check which value at index is not negative and add index + 1 in result array 
// Time Complexity : O(n) where n is the number of elements in nums array
// Space Complexity : O(1) since no extra space is considered for output array
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class FindDisappearedNumbers {
	public static List<Integer> findDisappearedNumbers(int[] nums) {
	       List<Integer> result = new ArrayList<Integer>();
	       if(nums==null || nums.length==0) return result;
	       for(int i=0; i<nums.length; i++) {
	           int index = Math.abs(nums[i])-1;
	           if(nums[index]<0) continue;
	           nums[index] = -nums[index];
	       }
	       for(int i=0; i<nums.length; i++) {
	           if(nums[i]>0) {
	               result.add(i+1);
	           }
	       }
	       return result;
	   }
	
	public static void main(String[] args){
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));
    }
}
