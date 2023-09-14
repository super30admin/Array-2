/*

Problem 1 : (https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)

Time Complexity : O(n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes

*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>(){};
        }
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<n; i++){
            int val = nums[i];
            int index = Math.abs(val) - 1;
            if(nums[index] > 0){
                nums[index] = nums[index] * -1;
            }
        }

        for(int i=0; i<n; i++){
            if(nums[i] > 0){
                res.add(i + 1);
            }
        }

        return res;
    }
}
