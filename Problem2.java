
import java.util.*;
import java.lang.*;
import java.io.*;
/*Algorithm:
  1. We will make pair wise comparision at each index.
  2. Initialize first element of the array as both min and max, which moving forward
  compare two elements. Out of the 2 compare the greater element with max and update accordingy.
  3. Do the same for min, handle the case when there are odd number of elements, where we calculate the max n min
  by comparing it with the last element only when we reach boundary.
  
  Time Complexity: O(n/2)
  Space Complexity: O(1)
  
  Did the code run successfully? Yes
*/
class GFG {
	public static void main (String[] args) {
	    
	    int[] arr = {-4,-1,20,3,4,6,0};
	    
	    int min=arr[0],max=arr[0];
	    
	    for(int i=0;i<arr.length;i+=2){
	        if(i==arr.length-1){
	            min = Math.min(min, arr[i]);
	            max = Math.max(max, arr[i]);
	        }
	       else if(arr[i]<arr[i+1]){
	            min = Math.min(min,arr[i]);
	            max = Math.max(max,arr[i+1]);
	        }
	        else{
	            min = Math.min(min,arr[i+1]);
	            max = Math.max(max, arr[i]);
	        }
	    }
	    
	    System.out.println("Max: "+max+" Min: "+min);
	   
	}
}