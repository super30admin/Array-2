// Time Complexity :O(n)-  One Iteration
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

import java.util.*;
import java.io.*;

class Solution_1 {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int index=0;
        
        //Iterate over entire array and find indexes of the array and negate it
        //The index of the positive elements +1 left in the array, indicates the missing number
        for(int i=0; i<nums.length; i++){
            index = Math.abs(nums[i])-1;
            
            if(nums[index] >0){
                nums[index] = -nums[index];
            }
        }
        for(int i=0; i<nums.length;i++){
            if(nums[i] > 0){
                result.add(i+1);
            }
        }
        return result;  
    }
    
    public static void main(String[] args) {
    		int[] input= {4,3,2,7,8,2,3,1};
    		
    		System.out.println("Missing elements in array: "+findDisappearedNumbers(input) );
    }
}