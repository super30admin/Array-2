// Time Complexity : 2n= O(n) [n=number of elements in array]
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes all testcase passed
// Any problem you faced while coding this :
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list=new ArrayList<>();
        // edge case
        if(nums.length==0 || nums==null) return list;
        // if we found any number then at that index-1 we will make value -ve
        for(int i=0;i<nums.length;i++)
        {
            int j=Math.abs(nums[i])-1;
            if(nums[j]>0) nums[j]*=-1;
        }
        // we need to check if value is not negative then that number is missing
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0) list.add(i+1);
        }
        return list;    
    }
}