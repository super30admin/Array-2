// Time Complexity :O(2N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach: change the value of indexes to negative so that the positive valued indexes+1 are the values that are missing.

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list=new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++){
        nums[Math.abs(nums[i])-1] = -Math.abs(nums[Math.abs(nums[i])-1]);
        }
        for(int j = 0; j < nums.length; j++){
            if(nums[j]>0){
                list.add(j+1);
            }
        }
        return list;
    }
}
