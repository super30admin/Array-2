// Time Complexity :O(n) n-length of the array
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes 
// Any problem you faced while coding this : -
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
 
            if(nums[Math.abs(nums[i])-1]>0)
               nums[Math.abs(nums[i])-1]*=-1; ;
            
        }
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0)
            list.add(i+1);
        }
        
        return list;
    }
}

//Brute force approach - TLE
/*
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list=new ArrayList<>();
        for(int i=1;i<=nums.length;i++)
        {
            list.add(i);
        }
        for(int i=0;i<nums.length;i++)
        {
            list.remove(Integer.valueOf(nums[i]));
        }
        
        return list;
    }
}
*/