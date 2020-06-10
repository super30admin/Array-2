// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/*https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]
*/
// Your code here along with comments explaining your approach

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length==0) return res;
        
       /* range of numbers 1 to n, in perfectly sorted array location of number = number - 1
          Itegrate through array, for each number, make nums[number-1] negative so we know
          number has been seen, at end traverse array to find non negative numbers,
          these are locations of the missing numbers
       */
        for(int i=0; i< nums.length; i++) {
            int num = Math.abs(nums[i]);
            nums[num-1] = Math.abs(nums[num-1]) * -1;
            
        }
        
        for(int i=0; i< nums.length; i++) {
            if(nums[i] > 0) {
                res.add(i+1);
            }
        }
        
        return res;
    }
}