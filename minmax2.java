import java.util.ArrayList;
import java.util.List;

//idea: compare current element with next element and keep  track of min and max number.
//# of comparisons when n is even: 1 + 3 * ((n-2)/2) = 1.5n-2.
//# of comparisons when n is odd: 1 + 3 * ((n-3)/2) + 2 = 1.5n

//did not understand time complexity
//space complexity is o(1)
////Did this code successfully run on Leetcode : no
//Any problem you faced while coding this:no

public class minmax2 {
	public static void minmax2(int[] a) {
	    if (a == null || a.length < 1)
	        return;

	    int min, max;

	    // if only one element
	    if (a.length == 1) {
	        max = a[0];
	        min = a[0];
	        System.out.println("min: " + min + "\nmax: " + max);
	        return;
	    }

	    //if two element or for first two elements
	    if (a[0] > a[1]) {
	        max = a[0];
	        min = a[1];
	    } else {
	        max = a[1];
	        min = a[0];
	    }

	    //for second element onwards calculate min and max by comparing current and next element .
	   // and then comparing those with min and max variables
	    for (int i = 2; i <= a.length - 2;) {
	        if (a[i] > a[i + 1]) {
	            min = Math.min(min, a[i + 1]);
	            max = Math.max(max, a[i]);
	        } else {
	            min = Math.min(min, a[i]);
	            max = Math.max(max, a[i + 1]);
	        }

	        i = i + 2;
	    }
	    //if array input length is odd compare min and max values with last element in an array

	    if (a.length % 2 == 1) {
	        min = Math.min(min, a[a.length - 1]);
	        max = Math.max(max, a[a.length - 1]);
	    }

	    System.out.println("min: " + min + "\nmax: " + max);
	}
	
	public static void main(String[] args) {
		int[] input = {4,3,2,7,8,2,3,1};
		minmax2(input);
		
		
	}

}
