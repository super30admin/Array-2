//Time Complexity : O(N)
//Space Complexity : O(1)
// did you try it on leetcode : yes

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
       if(nums == null || nums.length == 0)
           return new ArrayList<Integer>();
        List<Integer> result = new ArrayList<>();
        
        for(int i = 0; i<nums.length ; i++)
        {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index]>0)
                nums[index] = nums[index]*-1;
            else
                continue;
        }
        for(int i = 0;i<nums.length;i++)
        {
            if(nums[i]>0)
                result.add(i+1);
        }
        return result;
    }
}