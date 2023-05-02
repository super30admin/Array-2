//tc=O(n)
//sc=O(1)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = nums[index] * -1;
            }
        }

        for (int i = 0 ; i< nums.length; i ++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }    
        return result;     
    }
}