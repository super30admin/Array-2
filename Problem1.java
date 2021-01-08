class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        /**
         * Time complexity - O(n)
         * Space complexity - O(1)
         Algorithm:
         1. Iterate over the nums array
         2. Make index nums[i] negative if its not negative already
         3. Iterate over the array again and see if the number is positive add index+1 to list
         **/
        List<Integer> result = new ArrayList<Integer>();
        for(int i=0; i<nums.length; i++)
        {
            int temp = Math.abs(nums[i]);
            if(nums[temp-1]>0)
                nums[temp-1]*=-1;
        }
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i]>0)
                result.add(i+1);
        }
        return result;
    }
}