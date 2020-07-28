//Time complexity=O(n)
//Space complexity=O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
     if(nums==null || nums.length==0)
         return new ArrayList<>();
        List<Integer> li =new ArrayList<>();
        
        //We are iterating the same array and performing operation on it. Here we are changing the nums[nums[i]] to be negative and as we are iterating the array we are checking whether the value is +ve or not, if it is then we are adding that index + 1 to our list.
        for(int i=0;i<nums.length;i++)
        {
            int index=Math.abs(nums[i])-1;
           if(nums[index]>0)
               nums[index]=-nums[index];
        }
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0)
                li.add(i+1);
        }
        return li;
    }
}