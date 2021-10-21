// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ls = new ArrayList<>();
        int index;
        for(int i=0;i<nums.length;i++) {
            index = Math.abs(nums[i])-1;
            if(nums[index]>0) {
                nums[index] *= -1;
            } 
        }
        for(int i=0;i<nums.length;i++) {
            if(nums[i]>0) {
                ls.add(i+1);
            }
        }
        return ls;
    }
}