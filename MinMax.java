// Time Complexity : O(n-2) n is number of elements in the original array
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Arrays;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	    int[] arr = {5,4,1,6,2,9,3,4,8,7};			// considering all positive integers in the range of 1 to n(max number in the array)
        int[] result = new int[2];					// output array
	    //findminMax(arr);
        System.out.println(Arrays.toString(findminMax(arr)));
    }

    public static int[] findminMax(int[] arr){
        int[] minMax = new int[2];
        //int[] temp = new int[arr.length];
        if(arr == null || arr.length == 0){			// edge case
            return minMax;
        }
        Stack<Integer> stack = new Stack<>();		// using stack approach
        int max = -1;								// initialise min and max accordingly
        int min = 999;


        if(arr[0] > arr[arr.length - 1]){			// compare the first and last element of the array, which leaves us with n - 2 comparisons
            max = arr[0];							
            min = arr[arr.length - 1];
        }else{
            max = arr[arr.length - 1];
            min = arr[0];
        }



        for(int i = 1; i < arr.length - 1; i++){	// perform linear comparisons to find max 
            if(max < arr[i]){						// if the max is not greater than the current element, push it on to the stack
                max = arr[i];
            }else{
                stack.push(arr[i]);					// now the stack contains n - 3 elements, which excludes 1st, last and the max element from the original array
            }
        }
        while(!stack.isEmpty()){					// make n - 3 comparisons to find the min value from stack
            int temp = stack.pop();
            if(min > temp){
                min = temp;
            }
        }
        minMax[0] = min;							// assign the min and max to the output array and return. 
        minMax[1] = max;
        return minMax;								// total of 1 + (n-2) + (n-3) comparisons are made which is equal to the criteria of 2*n-2 comparisons;
    }
}
