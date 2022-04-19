//Time Complexity : O(n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //if the nums array is empty
        if(nums==null||nums.length==0)
            return new ArrayList<>();
        //output list
        List<Integer> output=new ArrayList<>();
        //iterating over all the elements
        for(int i=0;i<nums.length;i++){
            //search for the index, avoid negative value
            int index=Math.abs(nums[i])-1;
            //if there is a +ve value
            if(nums[index]>0)
                nums[index]=nums[index]*-1;
        }
        //iterate over the array again
        //if -ve value is found, change it to +ve
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0)
                nums[i]=nums[i]*-1;
            else
                output.add(i+1);
        }
        return output;
    }
}