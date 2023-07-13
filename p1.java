// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        // Sorting the array in O(n)
        List<Integer> ans = sort(nums);
        return ans;
    }

    // Sort function
    public List<Integer> sort(int[] nums) {

        // Storing output in a list
        List<Integer> ans = new ArrayList<>();
        int len = nums.length;

        // Iterating through the array and swapping elements as we know the end position
        // of the elements
        for (int i = 0; i < len; i++) {
            while (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        // Iterating through the elemtns and getting the position where the element does
        // not match with the position
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

    // Swap function

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
