class FindDisappearedNumbers {
    
    //Time Complexity: O(n) 
    //Space Complexity: O(1)
     
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;

        // Step 1: Mark visited numbers by making them negative
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1; // Get correct index (1-based to 0-based)
            if (nums[index] > 0) {
                nums[index] = -nums[index]; // Mark as visited (negative)
            }
        }

        // Step 2: Collect missing numbers (indices still positive)
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                result.add(i + 1); // Convert index to actual number
            }
        }

        return result;
    }
}