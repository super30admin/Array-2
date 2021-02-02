// Time Complexity : O(n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        // If a num exist update index num-1 to negative
        // By doing this the indexes that has missing number will be positive
        for(int i : nums) {
            int n = Math.abs(i)-1;
            if(nums[n]>0) {
                nums[n] *= -1;
            }
        }
        
        // If index is positive number index+1 is missing
        List<Integer> ans = new ArrayList<>();
        for(int i = 0;i<nums.length;i++) {
            if(nums[i]>0) {
                ans.add(i+1);
            }
        }
        return ans;
    }
}
