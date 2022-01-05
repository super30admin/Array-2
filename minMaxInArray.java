public class minMaxInArray {
    static class Pair {
        int min;
        int max;
    }
    static Pair getMinMax(int arr[], int n) {
        Pair minmax = new Pair();
        minmax.min = arr[0];
        minmax.max = arr[0];
        if(n == 1) {
            return minmax;
        }
        for(int i=1; i<n; i+=2) {
            if(arr[i] > arr[i-1]) {
                minmax.max = Math.max(minmax.max, arr[i]);
                minmax.min = Math.min(minmax.min, arr[i-1]);
            } else {
                minmax.min = Math.min(minmax.min, arr[i]);
                minmax.max = Math.max(minmax.max, arr[i-1]);
            }
        }
        if(n%2 == 1) {
            minmax.max = Math.max(minmax.max, arr[n-1]);
            minmax.min = Math.min(minmax.min, arr[n-1]);
        }
        return minmax;
    }

    public static void main(String args[]) {
        int arr[] = {10000, 11, 445, 10, 330, 3000, 50000};
        Pair minmax = getMinMax(arr, 7);
        System.out.printf("\nMinimum element is %d", minmax.min);
        System.out.printf("\nMaximum element is %d", minmax.max);
    }
}