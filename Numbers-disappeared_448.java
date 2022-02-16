// Time Complexity :O(n) where n is nums.length
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Iterate and Use the index of array to mark all the numbers seen so far by negating the values once.
// Again iterate and check which all numbers is positive, those index as numbers are missing
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            int index = Math.abs(nums[i])-1;
            if (nums[index] > 0){
                nums[index]*=-1;
            }
             
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i+1);
            }
        }
        return res;

    }
}
