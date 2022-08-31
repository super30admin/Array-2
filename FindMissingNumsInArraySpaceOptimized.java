// Time complexity: O(N)
// Space complexity: O(1)

// Approach: space optimized approach. Instead of using extra hashmap to store where an element is missing or not, we just use the original array. What we do is iterate over the original array, for every element we calculate which index it is supposed to be and for the element at that index, we just mark it as negative. So whenever there is an element present, it will be negative in the final array. So in the final array when something is positive, that index is missing the number so we add i+1 to the result. Note we are using math.abs so that we handle the case where an index has become negative before even reaching it

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] > 0) {
                nums[idx] *= -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i+1);
            }
        }
        return result;
    }
}