class Solution {
    //Time O(N)
    //Space O(1)
    public List<Integer> findDisappearedNumbers(int[] nums) {
         if(nums == null || nums.length == 0)
         {
             return new ArrayList<Integer>();
         }
        List<Integer> lis = new ArrayList<>();
        for(int i=0 ; i<nums.length ; i++)
        {
            int index = Math.abs(nums[i])-1;
            if(nums[index] > 0)
            {
                nums[index] *= -1;
            }
        }
        for(int i=0 ; i < nums.length ; i++)
        {
            if(nums[i] > 0)
            {
                lis.add(i+1);
            }
        }
        return lis;
    }
}