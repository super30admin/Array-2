// Time Complexity : O(n) --> where n is length of input array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MinMax {
    public static void main(String[] args) {
        int arr[] = new int[]{2,8,6,2,11,5,70};
        int len = arr.length;
        int min = arr[0];
        int max = arr[0];

        for (int i = 0; i < len; i = i + 2) {
            if (i == len - 1) {
                if (arr[i] > max) max = arr[i];
                if (arr[i] < min) min  = arr[i];
            }
            else if (arr[i] > arr[i + 1]) {
                if (arr[i] > max) max = arr[i];
                if (arr[i + 1] < min) min  = arr[i + 1];
            }
            else {
                if (arr[i + 1] > max) max = arr[i + 1];
                if (arr[i] < min) min  = arr[i];
            }
        }
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
    }
}