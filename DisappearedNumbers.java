class DisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> output = new ArrayList<>();

        for(int i = 0; i<nums.length;i++) {
            int idx = Math.abs(nums[i]) - 1;
            if(nums[idx] > 0) nums[idx] = -1 * nums[idx];
        }
        for(int i = 0; i<nums.length;i++) {
            if(nums[i] > 0) output.add(i+1);
        }
        return output;
    }
}