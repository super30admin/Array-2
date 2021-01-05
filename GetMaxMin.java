// Time Complexity : The time complexity is O(n) where n is the length of the array
// Space Complexity : The space complexity is O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// The total number of comparisions is 3(n-1)/2.

// Your code here along with comments explaining your approach
public class Main {

    static class Pair{
        int max;
        int min;
    }

    public static void main(String[] args) {
        int arr[] = { 1000, 11, 445, 1, 330, 3000 };
        int arr_size = arr.length;

        Pair val = getMaxMin(arr);

        System.out.println("Maximum value is " + val.max);
        System.out.println("Minimum value is " + val.min);

    }

    static Pair getMaxMin(int[] arr){

        Pair val = new Pair();
        int i=0;

        // If length is even, max and min are initialized with max and min between arr[0] and arr[1]
        if(arr.length % 2 == 0){
            if(arr[0] > arr[1]){
                val.max = arr[0];
                val.min = arr[1];
            }
            else{
                val.max = arr[1];
                val.min = arr[0];
            }
            i=2;
        }
        // If length is odd, max and min are initialized with arr[0]
        else{
            val.max = arr[0];
            val.min = arr[0];
            i=1;
        }

        // Compare each pair
        while(i < arr.length-1){

            if(arr[i] > arr[i+1]){
                if(arr[i] > val.max){
                    val.max = arr[i];
                }
                if(arr[i+1] < val.min){
                    val.min = arr[i+1];
                }
            }
            else{
                if(arr[i+1] > val.max){
                    val.max = arr[i+1];
                }
                if(arr[i] < val.min){
                    val.min = arr[i];
                }
            }
            i+=2;
        }
        return val;
    }
}