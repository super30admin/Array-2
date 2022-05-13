/**
 * Find Maximum and minimum of an array using minimum number of comparisons
 * 
 * time: O(n/2) => O(n)
 * space: O(1)
 * total comparisons: n/2 * 3 => 1.5n
 * 
 * Approach:
 * 1. compare 2 elements in a pair rather than comparing each with min and max
 * 2. compare the min out of them with min
 * 3. compare the max out of them with max
 */
class Problem32 {
    public int[] findMinMax(int[] nums){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i=i+2) {
            if (i == nums.length-1) {           // comparison 1
                min = Math.min(min, nums[i]);   // comparison 2
                max = Math.max(max, nums[i]);   // comparison 3
                break;
            }
            if (nums[i] < nums[i+1]) {          // comparison 1
                min = Math.min(min, nums[i]);   // comparison 2
                max = Math.max(max, nums[i+1]); // comparison 3
            } else {
                min = Math.min(min, nums[i+1]); // comparison 2
                max = Math.max(max, nums[i]);   // comparison 3
            }
        }
        return new int[]{min,max};
    }
}

public class MinMaxMinComparisons {
    public static void main(String[] args) {
        int[] nums = {1, 0, 3, 4, -8, 1, 6, 7};

        int[] result = new Problem32().findMinMax(nums);

        for (int i : result) {
            System.out.println(i);
        }
    }
}
