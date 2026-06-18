import java.util.ArrayList;
import java.util.Arrays;

public class MinAndMax {
    // TC = O(3n/2)
    // SC = O(1)
    public ArrayList<Integer> findMinMax(int[] arr) {
        int min, max, i;

        // to handle array with odd length, initialize min and max with arr[0] 
        // and iterate rest of the array in the same way
        if (arr.length % 2 == 1) {
            min = max = arr[0];
            i = 1;
        } else {
            // else set min and max from the first two indexes
            if (arr[0] < arr[1]) {
                min = arr[0];
                max = arr[1];
            } else {
                min = arr[1];
                max = arr[0];
            }
            i = 2;
        }

        // We process elements in pairs to minimize the number of comparisons
        while (i < arr.length - 1) {
            //compare the two indexes to find the lower number
            if (arr[i] < arr[i + 1]) {
                min = Math.min(min, arr[i]); // lower number is used for min comparison
                max = Math.max(max, arr[i + 1]); // higher value number is used to compare with max value
            } else {
                min = Math.min(min, arr[i + 1]); // lower number is used for min comparison
                max = Math.max(max, arr[i]); // higher value number is used to compare with max value
            }
            i += 2;
        }

        return new ArrayList<Integer>(Arrays.asList(min, max));
    }
}
