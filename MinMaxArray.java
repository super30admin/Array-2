public class MinMaxArray {

    static void getMinMax(int arr[], int n) {
        int i;
        int min;
        int max;

        if (n % 2 == 0) {
            if (arr[0] > arr[1]) {
                max = arr[0];
                min = arr[1];
            } else {
                min = arr[0];
                max = arr[1];
            }
            i = 2;
            
        } else {
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
        
        System.out.printf("Minimum element is %d", min);
        System.out.printf("\nMaximum element is %d", max);
    }
    public static void main(String args[]) {
        int arr[] = {1000, 11, 445, 1, 330, 3000};
        int arr_size = 6;
        getMinMax(arr, arr_size);
        
    }
}