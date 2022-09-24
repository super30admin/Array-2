// TC: O(n)
// SC: O(1)
// Works on leetcode
// No problem faced
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        for(int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] > 0) {
                nums[idx] *= -1;
            }
        }
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] > 0) {
                list.add(i);
            }
        }
        return list;
    }
}
