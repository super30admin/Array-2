//Time Complexity: O(N)
//Space Complexity: O(1)
public class Problem3 {
    static int[] getMinMax(int arr[], int n) {
        int max=Integer.MIN_VALUE;
        int min=Integer.MIN_VALUE;
        int i;
        if (n % 2 == 0) { // if arr.length is even
            if (arr[0] > arr[1]) {
                max = arr[0];
                min = arr[1];
            } else {
                min = arr[0];
                max = arr[1];
            }
            i = 2;
           
        } else { // if arr.length is odd
            min = arr[0];
            max = arr[0];
            i = 1;
        }
        
        while (i < n - 1) {
            if (arr[i] > arr[i + 1]) {
                if (arr[i] > max) {
                    max = arr[i];
                }
                if (arr[i + 1] < min) {
                    min = arr[i + 1];
                }
            } else {
                if (arr[i + 1] > max) {
                    max = arr[i + 1];
                }
                if (arr[i] < min) {
                    min = arr[i];
                }
            }
            i += 2;
        }

        return new int[]{min,max};
    }
    
    public static void main(String args[]) {
        int arr[] = {1000, 11, 445, 11, 330, 300,5};
        int arr_size = 7;
        int[] result = getMinMax(arr,arr_size);
        System.out.printf("\nMinimum element is %d", result[0]);
        System.out.printf("\nMaximum element is %d", result[1]);

    }
}
