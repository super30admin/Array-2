// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// In the first pass, if we come across a value i, we mark the value at index i-1 as negative
// if a number is already negative, we ignore as it means that num is not disappeared
// In the second pass, we form the result array by checking the sign of nums[i]. If it is postive, that means that it is one of the disappeared nos.
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int abs = Math.abs(nums[i]);
            if(nums[abs-1]>0)
                nums[abs-1]*=-1;
        }
        List<Integer> result = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0)
                result.add(i+1);
            else 
                nums[i]*=-1;
        }
        return result;
    }
}