// Time complexity: O(n) where n is length of the array. It takes 1.5 * n comparisions.
// Space complexity: O(1)

class MinAndMax {
    public static void main(String[] args) {
        int[] nums = {1, 4, 2, -3, 8, -9, 10};
        int max = Integer. MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length - 1; i+=2) {
            if(nums[i] > nums[i + 1]) {         // Comparing as pair of 2 numbers. So, total of 3 comparisions per loop and n/2 loops.
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[i + 1]);
            }
        }
        if(nums.length % 2 != 0) {              // Checking the last index since it's skipped in the for loop if length is odd.
            max = Math.max(max, nums[nums.length - 1]);
            min = Math.min(min, nums[nums.length - 1]);
        }
        System.out.println("Max: "+ max);
        System.out.println("Min: "+ min);
    }
}