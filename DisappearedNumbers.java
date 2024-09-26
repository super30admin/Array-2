//SC:O(1)
//TC:O(n)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> missingNums = new ArrayList<>();

        for(int num : nums)
        {
            //Look at the elemnt at that index.
            int index = Math.abs(num)-1;
            if(nums[index]> 0)
            {
                nums[index] = -nums[index];
            }
        }

        for (int i = 0 ; i < nums.length; i++)
        {
            if (nums[i] > 0)
            {
                missingNums.add(i+1);
            }
        }
        return missingNums;
    }
}