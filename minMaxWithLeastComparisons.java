/**
Problem: https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/
TC: O(n)
SC: O(1)
Comparisons:
	Even: 3(n - 2) / 2 + 1
	Odd: 3(n - 1) / 2
*/
public class MinMax {
	static class Pair {
		int min;
		int max;
	}

	static Pair getMinMax(int arr[], int n) {
		Pair minmax = new Pair();
        
        if (n == 1) {
            minmax.min = arr[0];
            minmax.max = arr[0];
            return minmax;
        }
        
        initializePair(arr, n, minmax);
        
        int i = (n % 2 == 0 ? 2 : 1);
        while ( i < n - 1) {
            if (arr[i] < arr[i+1]) {
                minmax.max = Math.max(minmax.max, arr[i + 1]);
                minmax.min = Math.min(minmax.min, arr[i]);
            } else {
                minmax.max = Math.max(minmax.max, arr[i]);
                minmax.min = Math.min(minmax.min, arr[i + 1]);
            }
            i += 2;
        }
        
		return minmax;
	}
    
    private static void initializePair(int arr[], int n, Pair minmax) {
        if (n % 2 == 0) {
            if (arr[0] > arr[1]) {
                minmax.max = arr[0];
                minmax.min = arr[1];
            } else {
                minmax.max = arr[1];
                minmax.min = arr[0];
            }
        } else {
            minmax.max = arr[0];
            minmax.min = arr[0];
        }
    }

	public static void main(String args[]) {
		int arr[] = {1000, 11, 445, 1, 330, 3000};
		int arr_size = 6;
		Pair minmax = getMinMax(arr, arr_size);
		System.out.printf("\nMinimum element: %d", minmax.min);
		System.out.printf("\nMaximum element: %d", minmax.max);

	}
}
