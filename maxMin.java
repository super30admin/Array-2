// Time Complexity :
// Space Complexity :

class Solution {
    public int[] maxMin(int[] nums) {
        int size = nums.length;
        int i = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MIN_VALUE;
        if (size % 2 != 0) {
            i = 1;
            min = max = num[0];
        }
        for (int j = i; j < size; j++) {
            if (nums[j] < nums[j + 1]) {
                max = Math.max(max, nums[j + 1]);
                min = Math.min(min, nums[j]);
            } else {
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j + 1]);
            }
        }
        return new int[] { max, min };
    }
}