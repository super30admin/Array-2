// Time Complexity : O(n)
// Space Complexity : O(1)
// Three line explanation of solution in plain english

// The number of comparisions can be reduced to 1.5*n by the following method.

// Your code here along with comments explaining your approach
class Solution {
  public int[] minMax(int[] nums) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for(int i = 0; i<nums.length-1; i++) {
      if(nums[i]>nums[i-1]) {
        max = Math.max(max, nums[i]);
        min = Math.min(min, nums[i+1]);
      }else {
        max = Math.max(max, nums[i+1]);
        min = Math.min(min, nums[i]);
      }
    }
    return new int[]{min, max};
  }
}