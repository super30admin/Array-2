package day11_Array2;

//Idea : 1. Compare first two elements and put their values in min and max variables accordingly.
//		 2. Next, compare the next two elements and update the min and max variables according to the comparison. 
//Time Complexity : O(n) where n is the number of elements in array
//Space Complexity : O(1) since two extra variables are used
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : no


public class MinMaxInArrayUsingMinComparisons {
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

	    if (a[0] > a[1]) {
	        max = a[0];
	        min = a[1];
	    } else {
	        max = a[1];
	        min = a[0];
	    }

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

	    if (a.length % 2 == 1) {
	        min = Math.min(min, a[a.length - 1]);
	        max = Math.max(max, a[a.length - 1]);
	    }

	    System.out.println("min: " + min + "\nmax: " + max);
	}
}
