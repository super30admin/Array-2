/**
LeetCode Submitted : YES
Space Complexity : O(1)
Time Complexity : O(N)

Idea is to make number negative on the index encountered when iterating an array
Then, check which number are non-negative and return index - 1
**/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> output  = new ArrayList<>();
        
        //Boundary Case
        if(nums == null || nums.length <1)
            return output;
        
        //Processing 
        for(int i =0; i< nums.length; i++){
            int check = Math.abs(nums[i]);
            if(nums[check-1] > 0)
                nums[check-1] = -nums[check-1];
        }
        
        //check
        for(int i =0; i< nums.length; i++){
            int check = nums[i];
            
            if(check > 0)
                output.add(i+1);
        }
        
        return output;
        
        
    }
}
