// Time complexity - O(n)
// Space complexity - O(1)

// For each element in array nums, convert the corresponding index value to negative. Those values which are positive are missing in the array. 

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // Convert each index value to negative
        for (int i = 0; i < nums.length; i++) {
            int newIndex = Math.abs(nums[i]) - 1;
            if (nums[newIndex] > 0) {
                nums[newIndex] *= -1;
            }
        }
      
        List<Integer> result = new LinkedList<Integer>();
        // Check missing values
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i+1);
            }
        }
        // return result
        return result;
    }
}
