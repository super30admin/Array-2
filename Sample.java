//Solution 1 for problem 29
//Number of comparison:2(N-1)
// Time Complexity :O[N]
// Space Complexity :o[1]
// Did this code successfully run on Leetcode :Couldn't find the problem in leetcode
// Any problem you faced while coding this : Brute force solution so not much problem faced
// Your code here along with comments explaining your approach
import java.io.*;

class Main {
  public static void main(String[] args) {
    int[] number = {7,23,12,45,89,-9,56,1009};
    findMinMax(number);

}
public static void findMinMax(int[] a) {
	//Checking if the array is null or invalid
    if (a == null || a.length < 1)
		return;
 
	int min = a[0];
	int max = a[0];
    //Iterating through array and printing the result
	for (int i = 1; i <= a.length - 1; i++) {
		if (max < a[i]) {
			max = a[i];
		}
 
		if (min > a[i]) {
			min = a[i];
		}
	}
 
	System.out.println("min: " + min + "\nmax: " + max);
}
}

//Solution 2 for problem 29
//Number of comparison: Couldn't determine but think it is lesser than the brute force solution
// Time Complexity :O[N]
// Space Complexity :o[1]
// Did this code successfully run on Leetcode :Couldn't find the problem in leetcode
// Any problem you faced while coding this : Trying to reduce the number of comparison
// Your code here along with comments explaining your approach

import java.io.*;

class Main {
  public static void main(String[] args) {
    int[] number = {7,23,12,45,89,-9,56,1009};
    findMinMax(number);

}
public static void findMinMax(int[] a) {
	//If the array is invalid return nothing
    if (a == null || a.length < 1)
		return;
 
	int min, max;
 
	// if it has only one element it is both the maximum and minimum
	if (a.length == 1) {
		max = a[0];
		min = a[0];
		System.out.println("min: " + min + "\nmax: " + max);
		return;
	}

    //If more than one element, compare the first 2 to get the initial maximum and minimum 
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
    
    //If the number of elements is odd, find the minimum and maximum between the computed minimum and maximum and the last element of the array
	if (a.length % 2 == 1) {
		min = Math.min(min, a[a.length - 1]);
		max = Math.max(max, a[a.length - 1]);
	}
 
	System.out.println("min: " + min + "\nmax: " + max);
}
}
