import java.util.Arrays;

//Given an array of numbers of length N, find both the minimum and maximum.
//Follow up : Can you do it using less than 2 * (N - 2) comparison

class Problem2 {
    static int[] minMax(int arr[]) {

        /* 2N comparisions
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int elem : arr) {
            max = Math.max(max, elem);
            min = Math.min(min, elem);
        }
        */
        

        // 2(N-1) comparisions
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        if (arr[0] > arr[1]) {
            max = arr[0];
            min = arr[1];
        } else {
            max = arr[1];
            min = arr[0];
        }
        for (int i=2;i<arr.length;i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }    
        return new int[] { min, max };
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(minMax(new int[]{1,4,6,8,9})));
    }
}
