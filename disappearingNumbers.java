/**
Problem: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
TC: O(n)
SC: O(1)
*/
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        
        if (n == 0) {
            return result;
        }
        
        int i = 0;
        while (i < n) {
            if((nums[i] == i + 1) || (nums[nums[i] - 1] == nums[i])) {
                ++i;
            } else {
                swap(nums, i, nums[i] - 1);
            }
        }
        
        for (i = 0; i < n; ++i) {
            if (nums[i] != i + 1) {
                result.add(i + 1);
            }
        }
        return result;
    }
    public void swap(int nums[], int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}