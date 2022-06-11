// Time Complexity : O(n)
// Space Complexity : O(1)

class Solution {
    public List<Integer> MaxAndMin(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i = i + 2) {
            if (nums[i] > nums[i + 1]) {
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[i + 1]);
            } else {
                max = Math.max(max, nums[i + 1]);
                min = Math.min(min, nums[i]);
            }
        }
        result.add(max);
        result.add(min);
        return result;
    }
}
