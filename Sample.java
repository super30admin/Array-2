## Problem1 (https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)

// Time Complexity : 0(n) because the solution performs two passes over the array, each of which takes linear time.
// Space Complexity : 0(1) because the solution uses only a constant amount of extra space regardless of the size of the input array.

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length ==0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = nums[index] * -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
            else {
                nums[i] = nums[i] * -1;
            }
        }
        return result;
    }
}


## Problem - (https://leetcode.com/problems/sort-colors/)

// Time Complexity : because the solution uses a single pass over the input array, and each element is processed exactly once.
// Space Complexity : because the solution only uses a constant amount of extra space regardless of the size of the input array.

class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;

        while (mid <= high) {
            if (nums[mid] == 2) {
                swap(nums, mid, high);
                high--;
            }
            else if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            }
            else {
                mid++;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}