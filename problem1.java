// Time Complexity: O(n)
// Space Complexity: O(1) constant, we use the input array itself

// We consider the element as the index of nums, and mark the value at index negative to indicate this number exists in the array. After 1 pass, we can check if any element is positive, those elements don't exist in array

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            int index = Math.abs(nums[i]) - 1; // we use absolute value because we may have marked it negative previously
            if (nums[index] > 0) {
                nums[index] = nums[index] * -1; // marking this index exists in the array
            } 
        }
        List<Integer> result = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            if (nums[i] > 0) result.add(i + 1);
            else nums[i] = nums[i] * -1; // restoring to original value
        }

        return result;
    }
}
