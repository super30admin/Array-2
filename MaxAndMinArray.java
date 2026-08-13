//Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) comparison
//Time Complexity : O(n) and 2n comparisions
//Space Complexity: O(1)
//Approach: Find min and max between pairs of elements while comparing them with global min and max values to get the final min and max values
public class MaxAndMinArray {

    public int[] FindMaxAndMin(int[] arr)
    {
        //Validate the inputs
        if (arr == null || arr.length == 0) return new int[]{-1, -1};

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length-1; i++)
        {
            if (arr[i] > arr[i+1])
            {
                max = Math.max(max, arr[i]);
                min = Math.min(min, arr[i+1]);
            }
            else
            {
                max = Math.max(max, arr[i+1]);
                min = Math.min(min, arr[i]);
            }
        }
        return new int[] {min, max};
    }
}
