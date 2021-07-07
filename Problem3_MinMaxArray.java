// Time Complexity :o(3n/2)
// Space Complexity : o(1)
// Did this code successfully run on GeeksforGeeks : Yes
// Any problem you faced while coding this : No

//https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/
// Your code here along with comments explaining your approach
public class Problem3_MinMaxArray {
	static class Pair {
		 
        int min;
        int max;
    }
	public static void main(String args[]) {
        int arr[] = {1000, 11, 445, 1, 330, 3000};
        int arr_size = 6;
        Pair minmax = getMinMax(arr, arr_size);
        System.out.println("\nMinimum element is"+ minmax.min);
        System.out.println("\nMaximum element is"+minmax.max);
 
    }
	private static Pair getMinMax(int[] arr, int arr_size) {
		// TODO Auto-generated method stub
		Pair minmax = new Pair();
        int i;
        int n=arr_size;
        if(n%2==0)
        {
        	if (arr[0] > arr[1]) {
                minmax.max = arr[0];
                minmax.min = arr[1];
            } else {
                minmax.min = arr[0];
                minmax.max = arr[1];
            }
        	i=2;
        }
        else {
            minmax.min = arr[0];
            minmax.max = arr[0];
            i = 1;
        }
        
        while(i<n-1)
        {
        	if(arr[i]>arr[i+1])
        	{
        		if(arr[i]>minmax.max)
        			minmax.max=arr[i];
        		if(arr[i+1]<minmax.min)
        			minmax.min=arr[i+1];
        			
        	}
        	else
        	{
        		if(arr[i+1]>minmax.max)
        			minmax.max=arr[i+1];
        		if(arr[i]<minmax.min)
        			minmax.min=arr[i];
        	}
        }
        
		return minmax;
	}
}
