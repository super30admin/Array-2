/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		//System.out.println("GfG!");
		Scanner scan= new Scanner(System.in);
		int n;
		n=scan.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++)
		{
		    arr[i]= scan.nextInt();
		}
		int min=Integer.MAX_VALUE; int max=Integer.MIN_VALUE;
		for(int i=0;i<n;i+=2)
		{
		    int num_1= arr[i];
		    if(i+1<n){
		    int num_2= arr[i+1];
		    if(num_1>num_2)
		    {
		        max=Math.max(num_1,max);
		        min=Math.min(num_2,min);
		    }
		    else
		    {
		        min=Math.min(num_1,min);
		        max=Math.max(num_2,max);
		    }
		    }
		    else{
		        max=Math.max(num_1,max);
		        min=Math.min(num_1,min);
		    }
		}
		System.out.println(max+" "+min);
		
	}
}