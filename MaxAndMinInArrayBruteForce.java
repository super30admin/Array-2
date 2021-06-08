// Brute Force
public class MaxAndMinInArrayBruteForce {
    public static int[] searchMinMax(int[] a) {
        int n = a.length;
        if (a == null || a.length == 0) {
            return new int[] {};
        }
        int[] result = new int[2];
        int i = 2, min, max;
        // assume 0th element denotes min, 1st element denotes max
        if(n == 1) {
            result[0] = a[0];
            result[1] = a[0];
        } else if(a[0] > a[1]) {
            result[0] = a[0];
            result[1] = a[1];
        } else {
            result[0] = a[1];
            result[1] = a[0];
        }
        while(i < n) {
            if(a[i] < result[0]) {
                result[0] = a[i];
            } else if(a[i] > result[1]) {
                result[1] = a[i];
            }
            i++;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] a = {14, -8, -76, 35, 7, 0, -5};
        int[] result = searchMinMax(a);
        System.out.print("Min=" + result[0] + ", Max=" + result[1]);
    }
}