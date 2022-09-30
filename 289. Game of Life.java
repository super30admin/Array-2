// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on gfg : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class pair  
{  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Compute obj = new Compute();
            pair product = obj.getMinMax(a, n); 
            System.out.println(product.first+" "+product.second);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

/*
 class pair  
{  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
} */

class Compute 
{
    static pair getMinMax(long a[], long n)  
    {
        pair minmax = new  pair(a[0],a[0]);
        if(a == null || a.length == 0) return minmax;
        int i=0;
        if(a.length == 1){
            minmax.first = a[0];
            minmax.second = a[0];
        }
        if(a.length==2){
            if(a[0]>a[1]){
                minmax.first = a[1];
                minmax.second = a[0];
            }else{
                minmax.first = a[0];
                minmax.second = a[1];
            }
        }
        
        if(a.length % 2 == 0){
            if(a[1]>a[0]){
                minmax.first = a[0];
                minmax.second = a[1]; 
            }else{
                minmax.first = a[1];
                minmax.second = a[0]; 
            }
            i=2;

        }else{
            minmax.first = a[0];
            minmax.second = a[0];
            i=1;
        }
        
        
        while(i<a.length-1){
            if(a[i]>a[i+1]){
                if(a[i]>minmax.second){
                    minmax.second = a[i];
                }
                if(a[i+1]<minmax.first){
                    minmax.first = a[i+1];
                }
            }else{
                if(a[i]<minmax.first){
                    minmax.first = a[i];
                }
                if(a[i+1]>minmax.second){
                    minmax.second = a[i+1];
                }                
            }
            i++;
        }
        return minmax;
    }
}
