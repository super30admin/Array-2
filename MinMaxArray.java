//Time complexity is O(N)
//Space complexity is O(N)
public class MinMaximum {
 
    static int[] getMinMax(int arr[], int n) {
        int[] minmax = new int[2];
        int i;
 
        if (n == 1) {
            minmax[0] = arr[0];
            minmax[1] = arr[0];
            return minmax;
        }

        if (arr[0] > arr[1]) {
            minmax[1] = arr[0];
            minmax[0] = arr[1];
        } else {
            minmax[1] = arr[1];
            minmax[0] = arr[0];
        }
 
        for (i = 2; i < n; i++) {
            if (arr[i] > minmax[1]) {
                minmax[1] = arr[i];
            } else if (arr[i] < minmax[0]) {
                minmax[0] = arr[i];
            }
        }
 
        return minmax;
    }
 
    public static void main(String args[]) {
        int arr[] = {1000, 11, 445, 1, 330, 3000};
        int arr_size = 6;
        int[] minmax = getMinMax(arr, arr_size);
        System.out.printf("\nMinimum element is %d", minmax[0]);
        System.out.printf("\nMaximum element is %d", minmax[1]);
 
    }
 
}