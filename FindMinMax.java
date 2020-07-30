// Time Complexity : O(3N/2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Not available on leetcode
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We have to find min and max with minimum number of comparisons. In the worst case we can have 2 comparisons
// per element to find min and max of the array, so 2N comparisons. If we want to get less than 2N comparisons,
// we can divide the array such that in the sub array there are only 2 elements. So that it takes only 3 comparisons
// to find min and max of 2 elements. So total comparisons for the array would be 3N/2.
public class FindMinMax {
    public static void main(String[] args) {
        int[] array = new int[]{34, 5, 6, 2, 67, 45, 8, 77};

        int[] minMax = getMinMaxValues(array);
        System.out.println("Minimum: " + minMax[0] + " Maximum: " + minMax[1]);
    }

    private static int[] getMinMaxValues(int[] array) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int index = 0;
        while (index < array.length - 1) {
            /*One comparison*/
            int tempMax, tempMin;
            if (array[index] < array[index + 1]) {
                tempMax = array[index + 1];
                tempMin = array[index];
            } else {
                tempMax = array[index];
                tempMin = array[index + 1];
            }
            max = Math.max(max, tempMax); /*second comparison*/
            min = Math.min(min, tempMin); /*third comparison*/
            index += 2;
        }
        return new int[]{min, max};
    }
}
