//TC: O(n)
//SC: O(1)
//approach: iterating over the array, comparing values in pairs to current min, max

public class MinMaxInArray {
    static class Pair {
        int min;
        int max;
    }

    static Pair getMinMax(int[] arr) {
        Pair minmax = new Pair();
        int startingIndex;

        if (arr.length % 2 == 0) {
            if (arr[0] > arr[1]) {
                minmax.max = arr[0];
                minmax.min = arr[1];
            } else {
                minmax.min = arr[0];
                minmax.max = arr[1];
            }
            startingIndex = 2;
        } else {
            minmax.min = arr[0];
            minmax.max = arr[0];
            startingIndex = 1;
        }

        for (int i = startingIndex; i < arr.length; i+=2) {
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
        }

        return minmax;
    }
}
