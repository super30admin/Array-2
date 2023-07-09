//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

// TIme Complexity = O(N)
//Space Complexity = O(1)
import java.io.*;
import java.util.*;




//User function Template for Java

class Solution
{
    public static int findSum(int A[],int N)
    {
        //code here

        int min1, min2;
        int max1, max2;
        min1 =max1= A[0];
        min2 = max2 = A[N/2];
        for(int i =0 ; i < N/2;i++){
            min1=Math.min(min1,A[i]);
            max1=Math.max(max1,A[i]);
        }

        for(int i =N/2; i < N;i++){
            min2 = Math.min(min2,A[i]);
            max2=Math.max(max2,A[i]);
        }

        return Math.min(min1,min2) + Math.max(max1,max2);
    }
}
