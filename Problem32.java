// Time Complexity: O(n)
//Space Complexity: O(1)
// Problem Name: max and min
public class Problem32 {

    public static int[] findMinMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }

        int n = arr.length;
        int min, max;

        // Initialize min and max based on the first element
        if (n % 2 == 0) {
            // If even number of elements, initialize both min and max
            if (arr[0] < arr[1]) {
                min = arr[0];
                max = arr[1];
            } else {
                min = arr[1];
                max = arr[0];
            }
            // Start comparing from the 2nd pair
            for (int i = 2; i < n; i += 2) {
                int localMin, localMax;
                if (arr[i] < arr[i + 1]) {
                    localMin = arr[i];
                    localMax = arr[i + 1];
                } else {
                    localMin = arr[i + 1];
                    localMax = arr[i];
                }
                // Update global min and max
                if (localMin < min) min = localMin;
                if (localMax > max) max = localMax;
            }
        } else {
            // If odd number of elements, initialize min and max based on the first element
            min = max = arr[0];
            // Start comparing from the 1st pair
            for (int i = 1; i < n; i += 2) {
                int localMin, localMax;
                if (i + 1 < n) {
                    if (arr[i] < arr[i + 1]) {
                        localMin = arr[i];
                        localMax = arr[i + 1];
                    } else {
                        localMin = arr[i + 1];
                        localMax = arr[i];
                    }
                } else {
                    localMin = localMax = arr[i];
                }
                // Update global min and max
                if (localMin < min) min = localMin;
                if (localMax > max) max = localMax;
            }
        }

        return new int[] {min, max};
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 5, 4, 1, 9};
        int[] result1 = findMinMax(arr1);
        System.out.println("Minimum element is: " + result1[0]);
        System.out.println("Maximum element is: " + result1[1]);

        int[] arr2 = {22, 14, 8, 17, 35, 3};
        int[] result2 = findMinMax(arr2);
        System.out.println("Minimum element is: " + result2[0]);
        System.out.println("Maximum element is: " + result2[1]);
    }
}
