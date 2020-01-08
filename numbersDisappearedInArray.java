// Time Complexity : O(n) where n is the length of the nums array
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach : As I iterate thru the nums array, I multiply the index of the number present at that index by -1
// After this, I iterate once again and put all those indices in the ans list which have postive numbers on them 

// Your code here along with comments explaining your approach

import java.util.*;
class numbersDisappearedInArray {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums.length == 0) return new ArrayList(); 
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] *= -1;    
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ans.add(i+1);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> ans = findDisappearedNumbers(nums);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}