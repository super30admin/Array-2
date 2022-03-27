/*

Time Complextiy : O(n)
Space Complexity : O(1)

*/

import java.util.Arrays;

public class Solution_minmax {

    public static void main(String[] args) {

        int[] arr = { 1000, 11, 445, 1, 330, 3000 };
        System.out.println(Arrays.toString(Solution_minmax.helper(arr)));

    }

    public static int[] helper(int[] arr) {

        int[] result = new int[2];

        if (arr.length == 0 || arr == null) {

            return result;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {

            if (min > arr[i]) {
                min = arr[i];
                result[0] = min;
            }
            if (max < arr[i]) {

                max = arr[i];
                result[1] = max;
            }
        }
        return result;

    }
}
