//TC & SC - O(n)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
            for (int i = 0; i < nums.length; i ++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = - nums[index];
            }        
        }
        List<Integer> result = new LinkedList<Integer>();
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
}