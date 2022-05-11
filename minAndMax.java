// Time Complexity :O(n)
// Space Complexity :constant
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// we are taking pairs and comparing pairs, then updating minimum and maximum. FOr eg if ptr1 is smaller,
// we will compare it for minimum with previous minimum and ptr2 we will compare for maxm with previous maximum
//this way we dec no of comparisons(in brute force, for a pair there are 4 comparisons) here there are 3 comparisons
public class Main {
    public static void main(String[] args) {
        // driver code
        int arr[] = { 1000, 11, 445, 1, 330, 3000 };
        int[] result = maxAndMin(arr);
        System.out.println("min is" + result[0]);
        System.out.println("max is" + result[1]);
    }

    public static int[] maxAndMin(int[] nums) {

        int[] result = { -1, -1 };
        if (nums == null || nums.length == 0)
            return result;
        int ptr1 = 0;
        int ptr2 = 1;
        int minm = Integer.MAX_VALUE;
        int maxm = Integer.MIN_VALUE;
        while (ptr1 < nums.length - 1) {
            ptr2 = ptr1 + 1;
            if (nums[ptr1] < nums[ptr2]) {
                minm = Math.min(minm, nums[ptr1]);
                maxm = Math.max(maxm, nums[ptr2]);
            } else {
                minm = Math.min(minm, nums[ptr2]);
                maxm = Math.max(maxm, nums[ptr1]);
            }
            ptr1 += 2;
        }
        if (nums.length % 2 == 1) {
            int n = nums.length - 1;
            maxm = Math.max(maxm, nums[n]);
            minm = Math.max(minm, nums[n]);
        }
        result[0] = minm;
        result[1] = maxm;
        return result;
    }
}