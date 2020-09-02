// Time Complexity : O (N) as we will be visiting the elements once.
                    // # of comparisons would be 3*(N/2) + 2 which is better than 2 * (N - 2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : ran it locally
// Any problem you faced while coding this : nope. similar to tournament matching problem

public class MinimumAndMaximum {
    class Pair {
        int min;
        int max;

        public Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }
    
    public int[] findMinAndMax(int[] nums) {
        Pair pair = helper(nums, 0, nums.length-1);

        return new int[]{pair.min, pair.max};
    }

    public Pair helper(int[] nums, int low, int high) {
        if(high == low) {
            return new Pair(nums[low], nums[low]);
        } else if( high - low == 1) {
            if(nums[low] <= nums[high]) {
                return new Pair(nums[low], nums[high]);
            } else {
                return new Pair(nums[low], nums[high]);
            }
        }

        int mid = low + (high - low)/2;
        Pair left = helper(nums, low, mid);
        Pair right = helper(nums, mid+1, high);

        int min = left.min <= right.min ? left.min : right.min;
        int max = left.max >= right.max ? left.max : right.max;

        return new Pair(min, max);
    }

    public static void main(String[] args) {
        int[] nums = {2,4,2,6,4,2,45,7,43,234,63,56,34,4,5,234,456,4,243,234};

        MinimumAndMaximum minMax = new MinimumAndMaximum();

        int[] pair = minMax.findMinAndMax(nums);
        System.out.println("min = " + pair[0] + " max = " + pair[1]);
    }
}