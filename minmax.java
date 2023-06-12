// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach:
// the main point of this problem is to reduce the comparisons. So we can take a pair and check the least element with min and max element with greatest element of the pair
// if the total length of the array is odd then we need to check the min and max with the last element of the array also.
public class GFG {

/* Class Pair is used to return two values from getMinMax() */


	public static int[] getMinMax(int arr[], int n) {
      int min = Integer.MAX_VALUE;
      int max= Integer.MIN_VALUE; 
		for(int i=0;i<= n-2;i=i+2){
          if(arr[i]<arr[i+1])
          {
            	if(arr[i]<min) 
                  min = arr[i];
            	if(arr[i+1]>max)
                  max=arr[i+1];
          } else {
            if(arr[i]>max)
                  max = arr[i];
            if(arr[i+1]<min)
              	min=arr[i+1];
          }
        }      
          if(n%2!=0)
          {
            if(max< arr[n-1])
              max= arr[n-1];
            if (min> arr[n-1])
              min = arr[n-1];
          }
       return new int[]{min,max};
    }

	/* Driver program to test above function */
	public static void main(String args[]) {
		int arr[] = {1000, 11, 445, 1111, 330, 3000,1};
		int arr_size = 7;
		int minmax[] = getMinMax(arr, arr_size);
		System.out.printf("Minimum element is %d", minmax[0]);
		System.out.printf("\nMaximum element is %d", minmax[1]);

	}
}