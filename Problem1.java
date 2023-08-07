// Time complexity= 2 O(N);
// Space Complexity = O(1);

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        //Multiplying the index value by -1 for the numbers present in the array if they are sorted.
        for(int num : nums){
            int index = Math.abs(num)-1;
            if(nums[index] >0){
                nums[index] = -nums[index];
            }
            // Adding the numbers to the result list whose index value are positive

        }
        for (int i=0; i <nums.length; ++i){
            if (nums[i]>0){
                result.add(i+1);
            }
            else nums[i] *= -1;
        }
        return result;
    }
}