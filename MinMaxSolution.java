// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Couldn't find on leetcode
// Any problem you faced while coding this : No

// We can reduce the number of comparisons by 1/3 by comparing in pairs
public class MinMaxSolution {
    public void findMinAndMax(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                min = Math.min(min, nums[i]);
                max = Math.max(max, nums[i - 1]);
            } else {
                min = Math.min(min, nums[i - 1]);
                max = Math.max(max, nums[i]);
            }
        }
 
        System.out.println("The minimum array element is " + min);
        System.out.println("The maximum array element is " + max);
    }
}
