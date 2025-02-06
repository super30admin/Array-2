class MinMaxFinder {
    static class Pair {
        int min, max;
    }
     // Time Complexity: O(N)
     // Space Complexity: O(1)
     
    static Pair findMinMax(int[] arr, int n) {
        Pair result = new Pair();
        
        int i = 0; 
        
        // If the array has an odd number of elements, initialize min and max with the first element
        if (n % 2 != 0) {
            result.min = result.max = arr[0];
            i = 1; // Start from the second element
        } else {
            // Initialize min and max with the first two elements
            if (arr[0] < arr[1]) {
                result.min = arr[0];
                result.max = arr[1];
            } else {
                result.min = arr[1];
                result.max = arr[0];
            }
            i = 2; // Start from the third element
        }

        // Process elements in pairs to minimize comparisons
        while (i < n - 1) {
            if (arr[i] < arr[i + 1]) {
                result.min = Math.min(result.min, arr[i]);      // Compare with min
                result.max = Math.max(result.max, arr[i + 1]);  // Compare with max
            } else {
                result.min = Math.min(result.min, arr[i + 1]);  // Compare with min
                result.max = Math.max(result.max, arr[i]);      // Compare with max
            }
            i += 2; // Move to the next pair
        }

        return result;
    }

}
