// Time Complexity : O(n).
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Approach : If we sort the Array, as the condition is 1 to n numbers, the element should be at i+1 index. Assuming this logic, we
// iterate through array and make the index's value-1 index to be negative. Which means all the numbers already present will be negative.
// Now we iterate again, and the index+1 of the positive numbers ill give the result.

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            int val = Math.abs(nums[i]);
            if(nums[val-1] > 0){
                nums[val-1] = -nums[val-1]; //marking the value that is supposed to be in this position to negative
            }
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i] > 0){ //non-negative number's index will be the ones that are not visited.
                res.add(i+1);
            }
        }
        return res;
    }
}