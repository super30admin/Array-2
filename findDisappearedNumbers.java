/*
Runtime complexity - O(N) as we loop through the entire array twice
Space complexity - O(1) - as we modify the input array and no additional space.

Problem type - State change
*/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i=0;i<nums.length;i++)
        {
            int index=Math.abs(nums[i])-1;
            if(nums[index]>0)
                nums[index]=nums[index]*-1;
        }
        List<Integer> disappeared_nums=new LinkedList<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0)
                disappeared_nums.add(i+1);
        }
        return disappeared_nums;
    }
}
