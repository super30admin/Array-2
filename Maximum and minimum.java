// time : n
// space : 1

import java.io.*;

class GFG {
	public static void main (String[] args) {

	    int arr[] = {1000, 11, 445, 1, 330, 3000}; //size - 6

	    int min = arr[0];
	    int max = arr[0];

	    for(int i=1 ; i<arr.length ; i++)
	    {
	        max = Math.max(arr[i],max); //5 comparisons
	        min = Math.min(arr[i],min); //5 comparisons
	    }

	    System.out.println("max - " + max);
	    System.out.print("min - " + min);
	}
}
