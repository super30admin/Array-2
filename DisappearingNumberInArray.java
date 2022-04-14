// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//marking the occurence of the number by putting negative at the index which is equal to the number-1.

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums==null||nums.length==0)
            return new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int i =0;i<nums.length;i++){
            if(nums[Math.abs(nums[i])-1]>0)
                nums[Math.abs(nums[i])-1] *= -1;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0)
                result.add(i+1);
            else
                nums[i]*=-1;
        }
        return result;
    }
}