// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Problem: (https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)

// Approach

/**
 * we put every number at its correct place if they are not
 * nums[i] showld belong at nums[i] - 1 index
 */

 import java.util.List;
 import java.util.ArrayList;

 class FindAllNumbersDisappearedinArray {
     public static void main(String[] args) {
         int[] nums = {4,3,2,7,8,2,3,1};

         System.out.println(findDisappearedNumbers(nums));
     }

     public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        
        // we put every number at its correct place if they are not
        // nums[i] showld belong at nums[i] - 1 index
        
        int i = 0;
        
        while(i < nums.length) {
            int correct_index = nums[i] - 1;
            
            int current_number = nums[i];
            
            if(current_number == nums[correct_index]) {
                i++;
            } else {
                // swap number at index i and correct_index
                
                int temp = nums[i];
                nums[i] = nums[correct_index];
                nums[correct_index] = temp;
            }
        }
        
        // iterate to find out which numbers are not at correct position
        
        for(int j=0;j<nums.length;j++) {
            if(nums[j] != j+1) {
                result.add(j+1);
            }
        }
        
        return result;
    }
 }

