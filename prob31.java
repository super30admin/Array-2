// S30 Big N Problem #31 {Easy}
// An array of numbers of length N is given , you need to find the minimum and maximum. try doing this in less than 2* (N-1) comparisons
// Time Complexity : <2(N-1) comparisons -> 2((N/2)-1)
// Space Complexity :No extra space
// Did this code successfully run on Leetcode : NA
// Any problem you faced while coding this :None


// Your code here along with comments explaining your approach
import java.io.*;

public class Solution{
	
	public static void main (String[] args) {
	    int [] array={2,6,70,15,9,54,97,2,4};
	    int len=array.length;
	    int max=array[0];
	    int min=array[0];
	    
	    for(int i=1;i<len;i++){
	        if(i==len-1){
	            max=Math.max(max,array[i]);
	            min=Math.min(min,array[i]);
	        }else if(array[i]>array[i+1]){
	            max=Math.max(max,array[i]);
	            min=Math.min(min,array[i+1]);
	        }else if(array[i]<array[i+1]){
	            max=Math.max(max,array[i+1]);
	            min=Math.min(min,array[i]);
	        }
	    }
		System.out.println(max);
		System.out.println(min);
	}
	
}