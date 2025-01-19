class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        int n = nums.length;
        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                results.add(i + 1);
            } else {
                nums[i] = -nums[i];
            }
        }

        return results;
    }
}