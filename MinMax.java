// Given an array of numbers of length N, find both the minimum and maximum. 
// Follow up : Can you do it using less than 2 * (N - 2) comparison

// Time Complexity: O(n)
// Space Complexity: O(1)
// Number of comparisons: 3n/2 - 2

public class MinMax {
    static int minComparisions = 0;
    private static int[] minMax(int[] arr) {
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        if(arr[0]<arr[1]){
            minComparisions+=1;
            min = arr[0];
            max = arr[1];
        } else{
            minComparisions+=1;
            min = arr[1];
            max = arr[0];
        }

        for (int i = 2; i < n - 1; i += 2) {
            if (arr[i] < arr[i + 1]) {
                minComparisions += 1;
                if (arr[i] < min) {
                    min = arr[i];
                    minComparisions += 1;
                }
                if (arr[i + 1] > max) {
                    max = arr[i + 1];
                    minComparisions += 1;
                }
            } else {
                minComparisions += 1;
                if (arr[i + 1] < min) {
                    min = arr[i + 1];
                    minComparisions += 1;
                }
                if (arr[i] > max) {
                    max = arr[i];
                    minComparisions += 1;
                }
            }
        }
        if (n % 2 != 0) {
            if (arr[n - 1] < min) {
                min = arr[n - 1];
                minComparisions += 1;
            } else if (arr[n - 1] > max) {
                max = arr[n - 1];
                minComparisions += 1;
            }
        }

        return new int[]{ min, max, minComparisions };
    }
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5};
        if (arr.length == 0) {
            System.out.println("Array is empty");
            return;
        }
        if (arr.length == 1) {
            System.out.println("Min: " + arr[0] + " Max: " + arr[0]);
            return;
        }
        int ans[] = minMax(arr);
        System.out.println("Min: " + ans[0] + "; Max: " + ans[1] + "; Min_Comparisions: " + ans[2]);
    }
}