class Sol{
    /*
    Time complexity: O(n) with 2n - 2 comparisons
    Sapce complexity: O(1)
    */

    // class to get min and max pair
    static class Pair{
        int min;
        int max;
    }

    // function to get min and max pair
    public static Pair Min_Max(int[] arr, int n) {
        Pair minmax = new Pair();
        int i = 0;

        // if n is even then
        if (n % 2 == 0) {
            // check the min and max among arr[0] and arr[1]
            if (arr[0] > arr[1]) {
                minmax.min = arr[1];
                minmax.max = arr[0];
            } else {
                minmax.min = arr[0];
                minmax.max = arr[1];
            }
            // start from 2
            i = 2;
        } else {
            // assign min and max as arr[0]
            minmax.min = arr[0];
            minmax.max = arr[0];
            // start from 1
            i = 1;
        }

        // find max and min from remaining n - 1 elements
        while (i < n - 1) {
            // check if arr[i] is greater than arr[i+1]
            if (arr[i] > arr[i + 1]) {
                // check if arr[i] is greater than the current max
                if (minmax.max < arr[i]) {
                    minmax.max = arr[i];
                }
                // check if arr[i+1] is lesser than the current min
                if (arr[i + 1] < minmax.min) {
                    minmax.min = arr[i + 1];
                }
            } else { // check if arr[i+1] is greater than arr[i]
                // check if arr[i+1] is greater than the current max
                if (arr[i + 1] > minmax.max) {
                    minmax.max = arr[i + 1];
                }
                // check if arr[i] is lesser than the current min
                if (arr[i] < minmax.min) {
                    minmax.min = arr[i];
                }
            }
            // increment by 2 for finding pairs
            i += 2;
        }
        // return the calculated pair
        return minmax;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 4, 3, 7, 5, 9 };
        int s = arr.length;
        // get the minmax pair
        Pair p = Min_Max(arr, s);
        // printing the result
        System.out.println("Minimum: " + p.min + " Maximum: " + p.max);
        }
}