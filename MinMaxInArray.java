// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : NA
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Assign first element as min and max, run the array loop
//If you see that the element is less or greater than min or max replace min and max
//Return the min and max
import java.io.*;

class GFG {
    static int[] minMax(int[] array){
        int min = array[0];
        int max = array[1];
        for(int i = 0; i < array.length; i++){
            if(array[i] < min)
                min = array[i];
            if(array[i] > max)
                max = array[i];
        }
        return new int[] {min,max};
    }
	public static void main (String[] args) {
	    int arr[] = {3,6,2,8,2,9,1};
        int []res = minMax(arr);
        System.out.println(res[0]);
        System.out.print(res[1]);
	}
}