//Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) comparison

// first we take min -infinity and max +infinity then compare each element in array with these min and max to find min and max 
// this will 2n comparisons

// to reduce comparisions we will compare in pairs





public class FindMinimumMaximum {

    public void minMax(int[] arr) {
        int min, max;
        int i = 0;

        // If the array has odd number of elements, initialize min and max to the first element
        if (arr.length % 2 == 0) {
            // If even, compare the first two elements to initialize
            if (arr[0] > arr[1]) {
                max = arr[0];
                min = arr[1];
            } else {
                max = arr[1];
                min = arr[0];
            }
            i = 2; // Start comparing from the third element
        } else {
            // If odd, initialize both to the first element
            min = arr[0];
            max = arr[0];
            i = 1; // Start comparing from the second element
        }

        // Compare elements in pairs
        while (i < arr.length - 1) {
            if (arr[i] > arr[i + 1]) {
                max = Math.max(max, arr[i]);
                min = Math.min(min, arr[i + 1]);
            } else {
                max = Math.max(max, arr[i + 1]);
                min = Math.min(min, arr[i]);
            }
            i += 2; // Move to the next pair
        }

        System.out.println("Minimum: " + min + ", Maximum: " + max);
    }

    public static void main(String[] args) {
        FindMinimumMaximum p = new FindMinimumMaximum();
        int[] arr = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        p.minMax(arr);
    }
}

