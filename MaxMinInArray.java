import java.util.ArrayList;
import java.util.List;

public class MaxMinInArray {

    public int[] getMaxMinInArray(int[] arr) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int i = 0;
        while(i < arr.length - 1) {
            if (arr[i] > arr[i+1]) {
                min = Math.min(arr[i + 1], min);
                max = Math.max(arr[i], max);
            } else {
                min = Math.min(arr[i], min);
                max = Math.max(arr[i +1], max);
            }
            i = i +2;
        }

        return new int[] {min, max};
    }

    public static void main(String[] args) {
        int[] arr = {3,6,9,2,10,60,80,10, 45};
        MaxMinInArray maxMinInArray = new MaxMinInArray();
        int[] result = maxMinInArray.getMaxMinInArray(arr);

        System.out.println("Min: "+ result[0] + " Max: " + result[1]);
    }
}
