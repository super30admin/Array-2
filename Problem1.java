//Problem1 (https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();


        if(nums == null || nums.length == 0)
            return result;

        for(int i=0;i<nums.length;i++){
            //FInd the positional value
            int index = Math.abs(nums[i])-1;
            if(nums[index]>0){
                //Make the number negative to indicate that the element exists
                nums[index] = -nums[index];
            }
        }

        for(int i=0;i<nums.length;i++){
            //If element is positive,add it to result
            if(nums[i]>0){
                result.add(i+1);
            }
        }
        return result;
    }
}
