class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i <= nums.length - 1; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = nums[index] * -1;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= nums.length - 1; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
}