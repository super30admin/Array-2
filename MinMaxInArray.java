import java.util.ArrayList;
import java.util.List;

//Time Complexity : O(n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/*
 We reduce the number of comparisons. We iterate left to right and compare pairs -> i and i+1.
 */
public class MinMaxInArray {
    
    static List<Integer> getMinMax(int arr[], int low, int high){
	List<Integer> res=new ArrayList<>();
	int min=Integer.MAX_VALUE;
	int max=Integer.MIN_VALUE;
	int i=low;
	while(i+1<=high) {
	    if(arr[i]>arr[i+1]) {
		max=Math.max(max, arr[i]);
		min=Math.min(min, arr[i+1]);
	    }else {
		max=Math.max(max, arr[i+1]);
		min=Math.min(min, arr[i]);
	    }
	    i=i+2;
	}
	if(high%2==0) {
	    max=Math.max(max, arr[high]);
	    min=Math.min(min, arr[high]);
	}
	res.add(min);
	res.add(max);
	return res;
    }
    
    
    public static void main(String args[])
    {
        int arr[] = { 1000, 11, 445, 1, 2,330, 3000 };
        int arr_size = 6;
        List<Integer> minmax = getMinMax(arr, 0, arr_size - 1);
        System.out.printf("\nMinimum element is %d",
                          minmax.get(0));
        System.out.printf("\nMaximum element is %d",
                          minmax.get(1));
    }
}
