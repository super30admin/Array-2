// Time Complexity : O(n) where n is length of array
// Space Complexity :O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class FindNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
             //Change the number in index nums[i] to a negative number
             nums[Math.abs(nums[i])-1]=Math.abs(nums[Math.abs(nums[i])-1]) * -1;
        }
        
        for(int i=0;i<nums.length;i++)
        {
            //Add the index+1 values of all positive numbers to list
           if(nums[i]>0)
               list.add(i+1);
        }
        
        return list;
    }
}