//The algorithm finds the minimum (min) and maximum (max) elements in pairs of adjacent elements in the array nums.
// It iterates through the array, comparing each pair and updating min and max accordingly. 
//The final result is the sum of the min and max values. 
//The time complexity is O(N), space -O(1)
//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java


import java.io.*;
import java.util.*;


class Array {
	public static void main (String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a[] = new int[n];
            
            for(int i=0;i<n;i++){
                a[i] = sc.nextInt();
            }
            
            Solution ob = new Solution();
            
            System.out.println(ob.findSum(a,n));
        }
        
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{ 
    public static int findSum(int nums[],int N) 
    {
        //code here
       // int n = nums.length;
    	int min = Integer.MAX_VALUE;
    	int max = Integer.MIN_VALUE;
    	if(N==1){
    	    return nums[0]+nums[0];
    	}
    	for(int i=0;i<N-1;i++){
    	    if(nums[i]<nums[i+1]){
    	        min = Math.min(min, nums[i]);
    	        max = Math.max(max, nums[i+1]);
    	    }
    	    else{
    	         min = Math.min(min, nums[i+1]);
    	        max = Math.max(max, nums[i]);
    	    }
    	    
    	} return (max+min);
    }
}
