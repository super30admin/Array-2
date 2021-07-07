// Time Complexity : O(n)  where n is number of elements in the array
// Space Complexity : O(1) since we are using only constant space
// Did this code successfully run on Leetcode : Yes


// Your code here along with comments explaining your approach


class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>(0);
      //Edge Case
        if(nums == null || nums.length==0)  return result;
        int n = nums.length;
      //Make all numbers negative based on the indexes
        for(int i=0;i<n;i++){
            int idx = Math.abs(nums[i])-1;
            if(nums[idx] > 0)
                nums[idx] *=-1;
        }
      // Find the numbers that are positive so the numbers that have not appeared in the array will be found using the index
        for(int i=0;i<n;i++){
            if(nums[i] >0)
                result.add(i+1);
        }
        return result;
    }
}
