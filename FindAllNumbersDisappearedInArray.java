// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> l = new ArrayList<Integer>();
        // Change state 
        for(int i=0;i<nums.length;i++){
            if(nums[Math.abs(nums[i])-1]>0){
               nums[Math.abs(nums[i])-1]= -nums[Math.abs(nums[i])-1]; 
            }
        }
        // Check for positive numbers as they are missing ones
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                l.add(i+1);
            }
        }
        return l;
    }
}