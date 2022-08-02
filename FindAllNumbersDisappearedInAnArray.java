import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// 1. Iterate through array, take the value at particular index and modify the number present at value-1 in the array by multiplying with -1.
// 2. After going through all items, iterate through array one  more time and check if the number at an index is negative.
// 3. If the number is positive at an index, that means the missing number is index+1. So, add index+1 to the list.

//448. Find All Numbers Disappeared in an Array (Easy) - https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0) {
                nums[val] *= -1;
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i+1);
            } else {
                nums[i] *= -1;
            }
        }
        
        return result;
    }
}