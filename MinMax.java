public class MinMax {
    static class Pair {
        int min;
        int max;
    }

    public static Pair findMinMax(int[] arr) {
        Pair result = new Pair();
        int n = arr.length;

        if (n == 1) {
            result.min = arr[0];
            result.max = arr[0];
            return result;
        }

        if (arr[0] < arr[1]) {
            result.min = arr[0];
            result.max = arr[1];
        } else {
            result.min = arr[1];
            result.max = arr[0];
        }

        for (int i = 2; i < n - 1; i += 2) {
            if (arr[i] < arr[i + 1]) {
                if (arr[i] < result.min) {
                    result.min = arr[i];
                }
                if (arr[i + 1] > result.max) {
                    result.max = arr[i + 1];
                }
            } else {
                if (arr[i + 1] < result.min) {
                    result.min = arr[i + 1];
                }
                if (arr[i] > result.max) {
                    result.max = arr[i];
                }
            }
        }

        if (n % 2 != 0) {
            if (arr[n - 1] < result.min) {
                result.min = arr[n - 1];
            } else if (arr[n - 1] > result.max) {
                result.max = arr[n - 1];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 5, 1, 9, 4, 7, 2, 8, 6 };
        Pair result = findMinMax(arr);
        System.out.println("Minimum: " + result.min);
        System.out.println("Maximum: " + result.max);
    }
}
