package TestPackage;

import java.util.Arrays;

public class MaxMinArray {
	public static void main(String[] args) {
		int arr[] = { 1000, 11, 445, 1, 330, 3000 };
		sortMin(arr);
		compMaxMin(arr);
	}

	public static void sortMin(int[] arr) {
		if(arr.length==1) {
			System.out.println("Min is : "+arr[0]);
			System.out.println("Max is : "+arr[0]);
			return;
		}
		if(arr.length==2) {
			System.out.println("Min is : "+arr[0]);
			System.out.println("Max is : "+arr[1]);
			return;
		}
		Arrays.sort(arr);
		System.out.println("Min is : "+arr[0]);
		System.out.println("Max is : "+arr[arr.length-1]);
		
	}
	
	public static void compMaxMin(int[] arr) {
		if(arr.length==1) {
			System.out.println("Min is : "+arr[0]);
			System.out.println("Max is : "+arr[0]);
			return;
		}
		if(arr.length==2) {
			System.out.println("Min is : "+arr[0]);
			System.out.println("Max is : "+arr[1]);
			return;
		}
		int min=Integer.MAX_VALUE;;
		int max=Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]<min) {
				min=arr[i];
			}else if(arr[i]>max) {
				max=arr[i];
			}
		}
		System.out.println("Min is : "+min);
		System.out.println("Max is : "+max);
	}

}
