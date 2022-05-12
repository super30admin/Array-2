//Time Complexity: O(n) 
//Space Complexity:o(1)
//Did this code successfully run on Leetcode :Yes


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

