// TC: O(n)
// SC: O(1)
public class MinMaxArray {
    public int[] findMinMax(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int n: arr) {
            if (min > n) min = n;
            if (max < n) max = n;
        }

        return new int[]{min, max};
    }
}
