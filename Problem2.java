// Time Complexity : O(n) as it is looping through all elements in arr once
// Space Complexity : O(1) as we are only storing and returning two constants
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem2 {
    public static void main(String[] args) {

        int[] arr = {3, 5, 4, 1, 9};
        int[] arr2 = {22, 14, 8, 17, 35, 3};
        System.out.println(findMinMax(arr)[0] + ", " + findMinMax(arr)[1]);
        System.out.println(findMinMax(arr2)[0] + ", " + findMinMax(arr2)[1]);
    }

    public static int[] findMinMax(int[] arr){
        int min, max;

        if(arr[0] > arr[1]){
            max = arr[0];
            min = arr[1];
        }else{
            max = arr[1];
            min = arr[0];
        }

        for(int i = 2; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }else if(arr[i] < min){
                min = arr[i];
            }
        }

        return new int[]{min, max};
    }
}
