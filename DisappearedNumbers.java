/*
Author: Akhilesh Borgaonkar
Problem: LC 448. Find All Numbers Disappeared in an Array (Array-2)
Approach: Compliment the powers of elements at index-1 in array and then check for positive power elements. The missing elements are the indexes+1 of
    positive elements.
Time Complexity: O(n) where n is number of elements in nums[]
Space complexity: O(1) no extra space other than output list
LC verified
*/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length==0)
            return new ArrayList<Integer>();
        
        List<Integer> output = new ArrayList<>();
        
        for(int i=0; i<nums.length; i++){
            int idx = Math.abs(nums[i])-1;          //getting the appropriate index   
            if(nums[idx]>0)
                nums[idx] = -nums[idx];             //complimenting the elements at index-1 in array
        }
        
        for(int i=0; i<nums.length; i++){           //checking for positive elements and returning their index+1
            if(nums[i] > 0)
                output.add(i+1);
        }        
        
        return output;
    }
}