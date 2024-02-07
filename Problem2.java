//## Problem2 
// Given an array of numbers of length N, find both the minimum and maximum. 
// Follow up : Can you do it using less than 2 * (N - 2) comparison
// https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/

// Time Complexity : O(1.5N + 1) --> O(N), where N is the number of elements in input array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : N/A
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// To reduce the number of comparisons we will use pair comparison

class Solution {
    public static int[] findMinMax(int A[]) 
    {
        //code here.
    	int min=Integer.MAX_VALUE;
    	int max=Integer.MIN_VALUE;
    	
    	int idx;
    	
    	// Comparison in pairs - Total Number of comparisons = 3*(n/2) + 1
    	for(idx=0;idx<A.length-1;idx=idx+2){
    	    // 3 comparisons in each iteration
    	    if(A[idx]<A[idx+1]){
    	        min=Math.min(A[idx], min);
    	        max=Math.max(A[idx+1], max);
    	    }else{
    	        min=Math.min(A[idx+1], min);
    	        max=Math.max(A[idx], max);
    	    }
    	}
    	
    	// Last element- in case of odd length array
    	if(idx==A.length-1){
    	    min=Math.min(A[idx], min);
    	    max=Math.max(A[idx], max);
    	}
    	
    	return new int[] {min, max};
    }
}