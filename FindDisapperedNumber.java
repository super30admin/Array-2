// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
    For every number in the list, we negate the number present at the index corresponding to that number.
    Subsequently, when we traverse the array the second time, we find all the non-negative numbers and them to the result.
*/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> result = new ArrayList<>();
        
        for (int i : nums){
            if (nums[Math.abs(i)-1] > 0)
                nums[Math.abs(i)-1] *= -1; 
        }
        
        for (int i=0; i<nums.length; i++){
            if (nums[i] > 0)
                result.add(i+1);
        }
        return result;
    }
}