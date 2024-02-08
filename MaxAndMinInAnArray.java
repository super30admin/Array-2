// Time Complexity : O(3n/2) == O(n/2)
// Space Complexity : O(1)

// Did this code successfully run on Leetcode : No, coded here
// Any problem you faced while coding this : No

/*
Approach -:
while iterating over the array, I took a pair of two numbers each time and compare to find the
minimum and maximum. Once I know which one is min or max, I can compare the number
with current min and current max.

If the array is having the odd size, performed comparison with the last element of the array
 */

public class MaxAndMinInAnArray {

    public static int[] getMaxAndMinInAnArray(int[] arr) {
        int[] result = new int[2];

        result[0] = Integer.MAX_VALUE; // min value
        result[1] = Integer.MIN_VALUE; // max value

        if(arr == null || arr.length == 0) return result;

        int len = arr.length;

        if(len == 1) return new int[]{arr[0], arr[0]};

        for(int i = 1; i < len; i+=2) {
            if(arr[i] < arr[i-1]) {
                result[0] = Math.min(result[0], arr[i]);
                result[1] = Math.max(result[1], arr[i - 1]);
            } else {
                result[0] = Math.min(result[0], arr[i - 1]);
                result[1] = Math.max(result[1], arr[i]);
            }
        }

        if(len%2 != 0) {
            if(arr[len - 1] < result[0]) {
                result[0] = arr[len - 1];
            } else {
                result[1] = arr[len - 1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result = getMaxAndMinInAnArray(new int[]{5, 4, 8, 9, 3});

        System.out.println("min -> " + result[0] + " & max -> " + result[1]);
    }
}
