import java.io.*;
public class Main {
	public static void main(String args[]) {
		int[] n = {7,5,2,3,10,1,6};
		int max = n[0];
		int min = n[0];
		if(n.length == 1){
		    System.out.println(max);
		    System.out.println(min);
		}
		
		for(int i = 1; i< n.length; i = i+2){
		    
		    if(i ==  n.length - 1){
		        if(max < n[i]){
		            max = n[i];
		        }
		       else if(min > n[i]){
		            min = n[i];
		        }
		    } 
		    else if(n[i]>n[i+1]){
		        if(max<n[i]){
		            max = n[i];
		        }
		        if(min>n[i+1]){
		            min = n[i+1];
		        }
		    }
		    else{
		        if(max<n[i+1]){
		            max = n[i+1];
		        }
		        if(min>n[i]){
		            min = n[i];
		        }
		    }
		}
		System.out.println(max);
		System.out.println(min);
		
	}