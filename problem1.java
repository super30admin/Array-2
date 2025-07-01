// Time Complexity : O(n)
// Space Complexity : O(1) as per question, we are not using any extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach - I use a similar technique to counting sort - I use the input array itself to mark the presence of numbers.
// For each number in the array, I mark the index corresponding to that number as negative.
// After processing all numbers, the indices that remain positive correspond to the numbers that are missing from the array.
// I simply return those elements as the result.

import java.util.ArrayList;
import java.util.List;
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i<nums.length;i++){
            nums[Math.abs(nums[i]) - 1] *= nums[Math.abs(nums[i]) - 1]<0?1:-1;
        }
        for(int i = 0; i<nums.length; i++) if(nums[i]>0) res.add(i+1);
        return res;
    }
}