public class MinMax {
    static class Pair {
        int min;
        int max;
    }

    static Pair getMinMax(int arr[], int n) {
        Pair minmax = new Pair();
        minmax.max = arr[0];
        minmax.min = arr[0];
        if (n == 0 || arr == null) {
            return minmax;
        }
        if (n == 1) {
            return minmax;
        }
        int j = 1;
        if (n % 2 == 0) {
            for (int i = 0; i < n; i = i + 2) {
                if (arr[i] > arr[j]) {
                    minmax.max = Math.max(minmax.max, arr[i]);
                    minmax.min = Math.min(minmax.min, arr[j]);
                } else {
                    minmax.max = Math.max(minmax.max, arr[j]);
                    minmax.min = Math.min(minmax.min, arr[i]);
                }
                j = j + 2;
            }
        } else {
            for (int i = 0; i <= n; i = i + 2) {
                if (j != n) {
                    if (arr[i] > arr[j]) {
                        minmax.max = Math.max(minmax.max, arr[i]);
                        minmax.min = Math.min(minmax.min, arr[j]);
                    } else {
                        minmax.max = Math.max(minmax.max, arr[j]);
                        minmax.min = Math.min(minmax.min, arr[i]);
                    }
                    j = j + 2;
                } else {
                    minmax.max = Math.max(minmax.max, arr[i]);
                    minmax.min = Math.min(minmax.min, arr[i]);

                }

            }
        }
        return minmax;

    }

    public static void main(String[] args) {
        int[] arr = { 3, 4, 8, 2, 9, 5, 15 };
        int arr_size = 7;
        Pair minmax = getMinMax(arr, arr_size);
        System.out.printf("\nMinimum element is %d",
                minmax.min);
        System.out.printf("\nMaximum element is %d",
                minmax.max);

    }
}
