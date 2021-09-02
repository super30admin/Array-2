//Time complexity: O(n)
//Space complexity: O(1)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        //abosulte value of index - 1, and convert the value to negative value
        for(int i = 0; i < nums.length; i++) {
            int new_index = Math.abs(nums[i]) - 1;
            if(nums[new_index] > 0) {
                nums[new_index] *= -1;
            }
        }

        for(int i = 1; i <= nums.length; i++) {
            if(nums[i-1] > 0) {
                result.add(i);
            }
            //optional , to get the original array back
            else {
                nums[i-1] *= -1; 
            }
        }
        return result;
    }
}