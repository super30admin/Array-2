// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
We are given an array.
for each num, we take absolute value and in the array at index (num-1) we make the number negative.
Hence, for all numbers visited we have negative.
Parse the array again and whichever number is positive return the index as that's the number which never came.
*/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();

        for(int i = 0; i < nums.length;i++){
            int num = Math.abs(nums[i]);
            if(nums[num-1] > 0){
             nums[num-1] = nums[num - 1] * -1;   
            }
        }

        for(int i = 0; i < nums.length;i++){
            if(nums[i] > 0){
                ans.add(i+1);
            }
        }

        return ans;
    }
} 