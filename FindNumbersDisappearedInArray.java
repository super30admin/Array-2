// Time Complexity : O(n*2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Bruteforce approach

import java.util.ArrayList;
import java.util.List;

class FindNumbersDisappearedInArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int count=0;
        for(int i=1;i<=nums.length;i++) {
            count = 0;
            for(int j=0;j<nums.length;j++) {
                if(nums[j] == i) count++;
            }
            if(count == 0) {
                result.add(i);
            }
        }
        return result;
    }
}


//Time Complexity : O(n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
//Make the corresponding index element of the value in array negative and finally check which numbers are positive

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            int value = Math.abs(nums[i]);
            if(nums[value - 1] > 0)
                nums[value - 1] *= -1;
        }
        for(int i=0;i<nums.length;i++) {
            if(nums[i]>0) {
                result.add(i+1);
            }
        }
        return result;
    }
}