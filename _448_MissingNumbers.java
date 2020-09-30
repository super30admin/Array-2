package com.javadwarf.leetcode;

import java.util.ArrayList;
import java.util.List;

//counting frequencies
public class _448_MissingNumbers {
	
	public static void main(String[] args) {
		System.out.println(findDisappearedNumbers(new int[] {4,3,2,7,8,2,3,1}));
	}

	/* same as counting frequencies
	 * Given an unsorted array of n integers which can contain integers from 1 to n
     *  so max element in array is less than equal to the size of array
     *  
     *  subtract 1 from each element
     *  
     *  we can get index by element as a[i] % n, this gives the a[i]'s count storage
     *  Now at the storage index i.e a[i] % 2 we want to store both count of index and original number
     *  a[a[i]%2] = a[a[i]%2] + n
     *  
     *  now if we divide this number a[a[i] % n ] by n, we get count
     *  and a[a[i] % n ] % n will give the value stored 
     *  
	 */
	
	public static List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> list = new ArrayList<Integer>();

		int n = nums.length;
		
		for(int i=0; i<n; i++) {
			nums[i] -= 1;
		}

		for(int i=0; i<n; i++) {
			nums[nums[i]%n] = nums[nums[i]%n] + n;
		}
		
		for(int i=0; i<n; i++) {
			if(nums[i]/n == 0) {
				list.add(i + 1);
			}
		}
		
		return list;

	}
	
	
}
