// Time Complexity : O(n), n is size of array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes, in geeksforgeeks ide
// Any problem you faced while coding this :


import java.io.*;

/*class Solution {
	public static void main (String[] args) {
		int[] arr = {2,5,9,-3,6,-7};
		int[] result = minmax(arr);
		System.out.println("Min : " +result[0]);
		System.out.println("Max : " +result[1]);
	}
	
	public static int[] minmax (int[] arr) {
	    if(arr == null || arr.length == 0) return new int[] {-1,-1};
	    
	    int[] res = new int[2];
	    int min = arr[0];
	    int max = arr[0];
	    
	    if(arr.length == 1) {
	        res[0] = min;
	        res[1] = max;
	        return res; 
	    }
	    
	    if(arr.length == 2) {
	        if(arr[0] >= arr[1]){
	            max = arr[0];
	            min = arr[1];
	        }
	        else {
	            max = arr[1];
	            min = arr[0];
	        }
	        res[0] = min;
	        res[1] = max;
	        return res; 
	    }
	    
	 
	    for(int i = 1; i < arr.length; i++) {
	        
	        if(arr[i] > max) {
	            max = arr[i];
	        }
	        else if(arr[i] < min) {
	            min = arr[i];
	        }
	    }
	    
	    res[0] = min;
	    res[1] = max;
	    
	    return res; 
	   
	}
}
*/





//less than 2(n-1) comparisions
//3*(n/2)-2 Comparisons if even
//3*(n-1)/2  comparisons if odd
//Pair wise comparisons
class Solution { 
  
    public static int[] findMinMax(int arr[], int n) { 
        int[] result = new int[2];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int i; 
        
		//if even no. of elements
        if (n % 2 == 0) { 
            if (arr[0] > arr[1]) { 
                max = arr[0]; 
                min = arr[1]; 
            } else { 
                min = arr[0]; 
                max = arr[1]; 
            } 
            i = 2; 
            
        } 
		
		//if odd no. of elemets
        else { 
            min = arr[0]; 
            max = arr[0]; 
            i = 1; 
        } 
  
       //pair wise comparisons with even and odd
        while (i < n - 1) { 
            if (arr[i] > arr[i + 1]) { 
                if (arr[i] > max) { 
                    max = arr[i]; 
                } 
                if (arr[i + 1] < min) { 
                    min = arr[i + 1]; 
                } 
            } else { 
                if (arr[i + 1] > max) { 
                    max = arr[i + 1]; 
                } 
                if (arr[i] < min) { 
                    min = arr[i]; 
                } 
            } 
            i += 2; //inc i count by 2 
            
        } 
        
		result[0] = min;
        result[1] = max;
  
        return result; 
    } 
  
    
    public static void main(String args[]) { 
        int arr[] = {2,6,8,1,10,250}; 
        int arrsize = 6; 
        int[] minmax = findMinMax(arr, arrsize); 
        System.out.println("Minimum element is " +minmax[0]); 
        System.out.println("Maximum element is " +minmax[1]); 
    } 
} 