// Time Complexity : O(n)
// Space Complexity : O(1)

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length;i++)
        {
            int index = Math.abs(nums[i]) - 1;
            //make the number at existing index negative
            if(nums[index] > 0)
                nums[index] = - nums[index];
        }
        //add the disappeared number to lisy
        for(int i = 0; i < nums.length;i++){
            if(nums[i] > 0)
                list.add(i + 1);
        }
        return list;
    }
}