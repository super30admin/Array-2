// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * Aproach: Nested for loop, Sort and Linear search, Sort and Binary Search, Hashset. Opitimized: index logic. 
 * As range of numbers is starting from 1-N, we can make value at that index-1 negative if it is present. Eg if 4 is present we go mark value negative at 4-1 index. as it is 0 based.
 * final we traverse the array and if at any index number is positive that means index+1 number was missing.
 */

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length < 1) {
            return new ArrayList<>();
        }
        List<Integer> result =new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0) {
                nums[index] = nums[index] * -1;
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                result.add(i + 1);
            } 
            else {
                nums[i] = Math.abs(nums[i]);
            }
        }
        return result;
    }
}
