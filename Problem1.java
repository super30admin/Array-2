class Problem1 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int index = 0;
        if(nums == null || nums.length == 0) return result;

        // changing the index of current value to -ve
        for(int i = 0; i < nums.length; i++){
            index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0){
                nums[index] *= -1;
            }
        }
        // adding all the indexes as numbers that were +ve meaning not found
        for(int i = 0; i<nums.length; i++){
            if(nums[i] > 0){
                result.add(i+1);
            }
            else{
                nums[i] = Math.abs(nums[i]);
            }
        }

        return result;
    }
}