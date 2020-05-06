// Time Complexity : O(n) where n is the number of elements 
// Space Complexity : O(1) inplace
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : coming up with negative idea
/* Your code here along with comments explaining your approach: Mark each of the element's indices as negative number. If the number has already been 
marked negative at some place, dont touch it. Iterate over the array to search for positive numbers and fetch their indices because, in the previous
step, all the indices present should have got marked negative if number was present. 
*/
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length == 0){return new ArrayList<>();}
        List<Integer> result = new ArrayList<>();
        for(int i = 0 ; i < nums.length; i++){
            if(nums[Math.abs(nums[i])-1] > 0){
                nums[Math.abs(nums[i])-1] = -nums[Math.abs(nums[i])-1];             // Mark the numbers negative at its indices
                }
            }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                result.add(i+1);                    // Iterate over the array to get the positive elements as the missing numbers
            }
        }
        return result;
    }
}