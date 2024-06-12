// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums.length==0 || nums==null)
            return new ArrayList<Integer>();
        
        //initialisation of list
        List<Integer> result = new ArrayList<Integer>();
        int index;
        //negating those indices whose values are present in the given array
        for(int i=0; i<nums.length; i++) {
            index = Math.abs(nums[i])-1;
            if(nums[index]>0)
                nums[index] *= -1;
        }
        //adding in result the indices whose values are not present in the array 
        for(int i=0; i<nums.length; i++) {
            if(nums[i]>0)
                result.add(i+1);
            else
                nums[i] *= -1; //again negating the values that are left resulting in the original array
        }
        return result;
    }
}