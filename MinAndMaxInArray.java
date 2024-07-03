

public class MinAndMaxInArray {

    public class Pair {
        int min;
        int max;
    }

    public Pair getMinMax(int arr[], int n) {

        Pair minMax = new Pair();

        int i;
        /* If array has even number of elements */
        if (n % 2 == 0) {
            if (arr[0] > arr[1]) {
                minmax.max = arr[0];
                minmax.min = arr[1];
            } else {
                minmax.min = arr[0];
                minmax.max = arr[1];
            }
            i = 2;

        } /* If array has odd number of elements */
        else {
            minmax.min = arr[0];
            minmax.max = arr[0];
            i = 1;
            /* set the starting index for loop */
        }

        while (i < n - 1) {
            if (arr[i] > arr[i + 1]) {
                if (arr[i] > minmax.max) {
                    minmax.max = arr[i];
                }
                if (arr[i + 1] < minmax.min) {
                    minmax.min = arr[i + 1];
                }
            } else {
                if (arr[i + 1] > minmax.max) {
                    minmax.max = arr[i + 1];
                }
                if (arr[i] < minmax.min) {
                    minmax.min = arr[i];
                }
            }
            i += 2;
        }

        return minmax;
    }

}