// Time complexity: O(N), where n is the size of the arr. 
// Space complexity: O(1), since constant extra space is used. 

public class Solution2 {
/* Class Pair is used to return two values from getMinMax() */
    static class Pair {
        int min;
        int max;
        
        Pair(int min, int max) {
            this.min = min; 
            this.max = max; 
        }
    }
    
	static Pair getMinMax(int arr[], int n) {
	    if(arr == null || arr.length == 0) return null; 
		int min=arr[0], max=arr[0]; 

        for (int i = 1; i < n; i++) {
            // element is greater than the max
            if (arr[i] > max) {
                max = arr[i];
            }
            // element is smaller than the min 
            else if (arr[i] < min) {
				min = arr[i];
			}
		}

		return new Pair(min, max);
	}

	/* Driver program to test above function */
	public static void main(String args[]) {
		int arr[] = {1000, 11, 445, 1, 330, 3000};
		int arr_size = 6;
		Pair minmax = getMinMax(arr, arr_size);
		System.out.printf("\nMinimum element is %d", minmax.min);
		System.out.printf("\nMaximum element is %d", minmax.max);

	}
}

