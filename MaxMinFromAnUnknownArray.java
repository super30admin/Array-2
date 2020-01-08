public class MaxMinFromUnknownArray {

    public static void main(String... args) {
        int[] array = {4,5,99,54,8,2};
        int n= array.length;
        int min=array[0], max = array[0];
        for (int i = 0; i < n; i=i+2) {
            if (i == n - 1) {
                max = Math.max(max, array[i]);
                min = Math.min(min, array[i]);
            } else if (array[i] > array[i + 1]) {
                max = Math.max(max, array[i]);
                min = Math.min(min, array[i + 1]);
            } else {
                max = Math.max(max, array[i + 1]);
                min = Math.min(min, array[i]);
            }
        }
        System.out.println(min);
        System.out.println(max);
    }
}
