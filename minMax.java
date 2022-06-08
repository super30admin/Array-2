// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Main {

    public static int[] minMax1(int[] nums) {
        // to store min value;
        int min = Integer.MAX_VALUE;
        // to store max value;
        int max = Integer.MIN_VALUE;
        // for traverse through all the elements.
        for (int i = 0; i < nums.length - 1; i += 2) {
            // first we are going to check two consective numbers which one is greater which
            // one is lesser
            if (nums[i] > nums[i + 1]) {
                // max element at nums[i] so we compare it with previous max
                max = Math.max(max, nums[i]);
                // min element at nums[i+1] so we compare it with previous min
                min = Math.min(min, nums[i + 1]);
            } else {
                // max element at nums[i+1] so we compare it with previous max
                max = Math.max(max, nums[i + 1]);
                // min element at nums[i] so we compare it with previous min
                min = Math.min(min, nums[i]);
            }
        }
        // return result;
        return new int[] { min, max };
    }

    // approch 2
    // normal 2n comparision
    public static int[] minMax2(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // her there is 2n comparision
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min);
        }
        return new int[] { min, max };

    }

    public static void main(String[] args) {
        int[] nums = { 12, 3, 4, 5, 3000, 1 };
        int[] result = minMax1(nums);
        System.out.println("min element is: " + result[0] + "\nmax element is: " + result[1]);

        result = minMax2(nums);
        System.out.println("min element is: " + result[0] + "\nmax element is: " + result[1]);
    }
}