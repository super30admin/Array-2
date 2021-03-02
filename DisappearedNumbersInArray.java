class DisappearedNumbersInArray {
    
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return result;
        
        for(int i = 0; i < nums.length; i++){
            int curr = nums[i] < 0 ? -nums[i] : nums[i];
            int index = curr - 1;
            
            if(nums[index] > 0)
                nums[index] = -nums[index];
        }
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0)
                result.add(i+1);
        }
        return result;
    }
}