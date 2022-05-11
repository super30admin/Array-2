// Time Complexity :O(n^2)
// Space Complexity :constant
// Did this code successfully run on Leetcode :TLE
// Any problem you faced while coding this :TLE

//we are doing nested loops to check if at each index each number is present , 
//if it is not, we add it in result
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;
        int n = nums.length;
        int count = 1;
        boolean found = false;
        while (count <= n) {
            found = false;
            for (int i = 0; i < n; i++) {
                if (nums[i] == count) {
                    found = true;
                }
            }
            if (!found) {
                result.add(count);
            }
            count++;
        }
        return result;
    }
}

// -----------OPTIMIZED---------------------
// Time Complexity :O(n) where n is no of elements
// Space Complexity :constant
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// going through each index, we mark num[index]-1 negative if it is already not
// negative
// at the end we check which indices are not negative that means we didn't come
// across that number so we add index+1 in result array
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            int ele = nums[i];
            if (nums[i] < 0) {
                ele *= -1;
            }
            int index = ele - 1;
            if (nums[index] > 0) {
                nums[index] *= -1;
            }

        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
            if (nums[i] < 0) {
                nums[i] *= -1;
            }

        }

        return result;
    }
}