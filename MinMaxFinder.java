public class MinMaxFinder {

    public static int[] findMinMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[]{};
        }

        int min, max;
        int startIndex;

        if (arr.length % 2 == 0) {
            if (arr[0] < arr[1]) {
                min = arr[0];
                max = arr[1];
            } else {
                min = arr[1];
                max = arr[0];
            }
            startIndex = 2;
        } else {
            min = arr[0];
            max = arr[0];
            startIndex = 1;
        }

        for (int i = startIndex; i < arr.length; i += 2) {
            if (arr[i] < arr[i + 1]) {
                min = Math.min(min, arr[i]);
                max = Math.max(max, arr[i + 1]);
            } else {
                min = Math.min(min, arr[i + 1]);
                max = Math.max(max, arr[i]);
            }
        }

        return new int[]{min, max};
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 2, 6, 7, 8, 0};
        int[] result = findMinMax(arr);
        System.out.println("Min: " + result[0] + ", Max: " + result[1]);
    }
}
