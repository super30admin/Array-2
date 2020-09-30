// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> list  = new ArrayList<>();

        if(nums.length == 0 || nums == null)
        {
            return list;
        }

        for(int i = 0 ; i<nums.length ; i++)
        {
            int current = Math.abs(nums[i]);
            nums[current-1] = -1*Math.abs(nums[current-1]);
        }

        for(int i = 0 ; i<nums.length ; i++)
        {
            if(nums[i]>0)
            {
                list.add(i+1);
            }
        }
        return list;


    }
}
