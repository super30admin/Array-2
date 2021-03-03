// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// In this approach we iterate through every element of the array and do a temp state change.
//If for example the first number is 4 , then we make the number at index 3(starting from ) of the array as negative.
//We do this for all the elements of the array. In the end we return the index + 1 where the elements in the array are not negative.

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
      
      List<Integer> result = new ArrayList<>();
      for(int i =0;i<nums.length;i++)
      {
        //get the positive value of the element-1 
        int x = Math.abs(nums[i])-1;
        
        if(nums[x]>0)
        {
        	//making the element at index nums[i] of the array as negative.
        	nums[x] = nums[nums[i]] * (-1);
        }
        
      }
      
      for(int i =0;i<nums.length;i++)
      {
    	//adding to result list only the numbers that couldn't be made negative
    	//Those are the ones that are missing in the original array
        if (nums[i] > 0 )
        {
          result.add(i+1);
        }
      }
        return result;
    }
}