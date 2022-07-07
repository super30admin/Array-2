// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList();
        }
        
        List result = new ArrayList<Integer>();
        
        for(int i = 0; i < nums.length; i++){
            // Find the correct index of the element
            // Mark it negative to show that it was visited
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0){
                nums[index] = nums[index] * -1;
            }
        }
        
        for(int i = 0; i < nums.length; i++){
            // The index+1 is the missing number. Add it to the result
            if(nums[i] > 0){
                result.add(i + 1);
            }
            else{
                // reverting the marking to keep the original array
                nums[i] = nums[i] * -1;
            }
        }
        return result;
    }
}