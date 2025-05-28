// TC : O(n)
// SC : O(1)
// Approach : Iterate through the whole array and compare with prev min and max 

public class FindMinAndMax {

    public int setmin(int[] arr, int n) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                min = arr[i];
            }
        }
        return min;
    }

    public int setmax(int[] arr, int n) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        FindMinAndMax mm = new FindMinAndMax();
        int[] arr = new int[] { 3, 5, 4, 1, 9 };
        int n = arr.length;

        System.out.println(mm.setmin(arr, n));
        System.out.println(mm.setmax(arr, n));
    }
}