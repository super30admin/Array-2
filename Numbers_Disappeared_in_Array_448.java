//Time Complexity : O(n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : None

package com.s30.satish;

import java.util.*;

class Numbers_Disappeared_in_Array_448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        List<Integer> ar = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++)
        {
        	if(nums[Math.abs(nums[i]) - 1 ] > 0)
        	{
        		nums[Math.abs(nums[i]) - 1 ] *= -1; 
        	}
        }
        
        for(int i = 0; i < nums.length; i++)
        {
        	if(nums[i] < 0)
        		nums[i] *= -1;
        	else
        		ar.add(i+1);
        }
        return ar;
    }
    
    public static void main(String[] args)
    {
    	int[] nums = {4,3,2,5,6,8,3,1};
    	Numbers_Disappeared_in_Array_448 DisArr = new Numbers_Disappeared_in_Array_448();
    	
    	List<Integer> list = new ArrayList<>();
    	list = DisArr.findDisappearedNumbers(nums);
    	for(int i : list)
    		System.out.print(i +" ");
    }
}
