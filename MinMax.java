package com.array2;

//m is the maximum element from the array
//n is total elements in the input array
//Time complexity: O(n)
//Space Complexity: O(m)

public class MinMax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[]= {5,2,7,9,3,6,4,8,56,3,2,45};
		int max=0,min=0;
		
		for(int num:nums) {
			max = Math.max(max, num);
		}
		int arr[]= new int[max+1];
		
		for(int num: nums) {
			arr[num]++;	//Counting sort
		}
		/*
		 * arr[] after counting sort
		 * 
		 * 0 0 2 2 1 1 1 1 1 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
		 * 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 1 
		 */

		for(int i=0;i<arr.length;i++) {
			
			if(arr[i] >= 1) {
				min = i;	//find first element which is the minimum element
				break;	//to avoid computations
			}
		}
		
		System.out.println("Minimum element : "+min+"\nMaximum Element : "+max);
		
	}
}
