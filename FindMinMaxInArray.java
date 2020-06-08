// Time Complexity : O(n), n is size of array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes, in geeksforgeeks ide
// Any problem you faced while coding this :


import java.io.*;

class Solution {
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
