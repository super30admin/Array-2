// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        //if array is empty, return empty array list
        if(nums.length == 0 || nums == null){
            return new ArrayList<>();
        }
        
        //initialize the output array list
        List<Integer> output = new ArrayList<>();
        
        //for every number value, we go to the index - 1 in the array and negate it
        for(int num : nums){
            int index = Math.abs(num) - 1;
            if(nums[index] > 0){
                nums[index] *= -1;
            }
        }
        
        //again traverse over the array
        //return index + 1 of the number values which are left positive
        //These would be the missing numbers
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                output.add(i+1);
            }
        }
        
        //return output array list with missing numbers
        return output;
    }
}