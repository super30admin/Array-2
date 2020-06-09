// Time Complexity : O(n). n is the length of the array
// Space Complexity :O(1)
//No of comparisions: 
if length is odd, then 3*(n-1)/2. else 3n/2-2

// Did this code successfully run on Leetcode : 
// Any problem you faced while coding this :No


public class MinMax {

	public static void main(String[] args) {
		int arr[] = { 1000, 11, 445, 1, 0};

		minMax(arr);

	}

	private static void minMax(int[] arr) {
		if (arr == null || arr.length == 0)
			return;

		int incrementByVal = 0;
		int min = arr[0];
		int max = arr[0];
		
		int len=arr.length;
		int l=len/2;
		if (arr.length % 2 == 0) {
			if (arr[0] > arr[1]) {
				max = arr[0];
				min = arr[1];
			} else {
				max = arr[1];
				min = arr[0];
			}

			incrementByVal = 2;

		} else {
			min = arr[0];
			max = arr[0];
			incrementByVal = 1;
		}

		for (int i = incrementByVal; i < arr.length - 1; i+=2) {
			
			if(arr[i]>arr[i+1]) {
				if(arr[i]>max) 
					max=arr[i];
					if(arr[i+1]<min)
						min=arr[i+1];
				
					
			}else {
				if(arr[i]<min)
					min=arr[i];
				if(arr[i+1]>max)
					max=arr[i+1];
			}	
		}

	}

}
