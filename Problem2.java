// Time Complexity : O(n)
// Space Complexity : O(1)

public class minMax {

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 8, 6, 2, 11, 5, 70 };

        int[] result = computeMinANDMax(arr);
        System.out.println("Min is " + result[0] + " and max is " + result[1]);
    }

    private static int[] computeMinANDMax(int[] arr) {

        int min, max;
        int index;

        if (arr.length % 2 == 0) {

            if (arr[0] > arr[1]) {
                max = arr[0];
                min = arr[1];
            } else {
                max = arr[1];
                min = arr[0];
            }
            index = 2;

        } else {
            min = arr[0];
            max = arr[0];
            index = 1;
        }

        for (int i = index; i < arr.length - 1; i = i + 2) {
            if (arr[i] > arr[i + 1]) {
                max = Math.max(max, arr[i]);
                min = Math.min(min, arr[i + 1]);
            } else {
                max = Math.max(max, arr[i + 1]);
                min = Math.min(min, arr[i]);
            }
        }

        return new int[] { min, max };
    }

}
