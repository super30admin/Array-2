// Time Complexity : O(N) with less then 2(N-2) comparsions
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[] {4, 5, 6, 1, 2, 3, 9, 10};
        int index, max, min;
        if(arr.length%2 == 1)
        {
            max=arr[0];
            min=arr[0];
            index=1;
        } else {
            if(arr[0] > arr[1]){
                max=arr[0];
                min=arr[1];
            } else {
                max=arr[1];
                min=arr[0];
            }
            index=2;
        }
        for (int i = index; i < arr.length; i+=2)
        {
            if(arr[i] > arr[i+1]) {
                max=Math.max(arr[i], max);
                min=Math.min(arr[i+1], min);
            } else {
                max=Math.max(arr[i+1], max);
                min=Math.min(arr[i], min);
            }
        }
        System.out.println("Max: "+max+" and Min: "+min);
    }
}