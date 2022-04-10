// Time Complexity : O(n) - Iterating once for marking nodes and the other for checking the numbers. O(n + n)~O(2n)~O(n)
// Space Complexity : O(1); in-place constat space; just using some variables
// Did this code successfully run on Leetcode : Yes;(https://leetcode.com/submissions/detail/676997409/)
// Any problem you faced while coding this : No;
// My Notes : For the value exist; go to their node position and make them -ve; Iterate the +ve ones which are the disappered elems
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // Iterate the array and mark the reference position as -ve
        for(int i=0;i<nums.length;i++){
            int idx = Math.abs(nums[i])-1;
            if(nums[idx]>0){
                // Preserve the numbers by making them -ve instead of marking them with sum other number.
                nums[idx]*=-1;
            }
        }
        
        // Check if the nums is positve and to the result to return.
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                result.add(i+1);
            }
        }
        return result;
    }
}