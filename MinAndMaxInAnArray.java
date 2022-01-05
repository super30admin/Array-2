class Solution {
    // Time Complexity : O(n)
    // Space Complexity : O(1)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No

    public static void findMinMax(int[] arr, int n) {
        int min = 0;
        int max = 0;
        int i = 0;
        if(n%2 == 0) {
            if(arr[0] > arr[1]) {
                min = arr[1];
                max = arr[0];
            } else {
                min = arr[0];
                max = arr[1];
            }
            i = 2;
        } else {
            min = arr[0];
            max = arr[0];
            i = 1;
        }

        while(i < n-1) {
            if(arr[i] > arr[i+1]) {
                min = Math.min(min, arr[i+1]);
                max = Math.max(max, arr[i]);
            } else {
                min = Math.min(min, arr[i]);
                max = Math.max(max, arr[i+1]);
            }
            i+=2;
        }
        System.out.println(min);
        System.out.println(max);
    }

    public static void main(String args[]) {
        int arr[] = {1000, 11, 445, 1, 330, 3000};
        int arr_size = 6;
        findMinMax(arr, arr_size);
    }
}