// Problem1 (https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)

// Time Complexity : O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, traverse along the array and for the value at an index change the value at present values index to negative if its positive. Then,
 * check for positive values in array and return the positive values.
 */

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<n;i++){
            int idx = Math.abs(nums[i])-1;
            if(nums[idx]>0){
                nums[idx] *= -1;
            }
        }

        for(int i = 0;i<n;i++){
            if(nums[i]>0){
                list.add(i+1);
            }
            else{
                nums[i] *= -1;
            }
        }

        return list;
    }
}