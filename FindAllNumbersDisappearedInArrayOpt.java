// TC: O(n)
// SC: O(1)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        int i, n;
        n = nums.length;
        for(i = 0; i < n; i++) {
            int ind = Math.abs(nums[i]) - 1;
            if(nums[ind] > 0) {
                nums[ind] = nums[ind] * -1;
            }
        }
        for(i = 0; i < n; i++) {
            if(nums[i] > 0) {
                result.add(i + 1);
            } else {
                // we are doing this step because we are changing the array back to original stage
                nums[i] = -1 * nums[i];
            }
        }
        return result;
    }
}