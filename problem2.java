 import java.util.*;
public class problem2 {

    public static void minMax(int[] arr) {
        int max =0; int min = 0;
        if(arr.length>0) {
        max = arr[0]; min = arr[0];
        max = (arr[0]>= arr[1]) ? arr[0] : arr[1];
        for(int i=2;i<arr.length-2;) {
            if(arr[i]>arr[i+1]) {
                max = Math.max(max, arr[i]);
                min = Math.min(min, arr[i+1]);
            }
            else {
                max = Math.max(max, arr[i+1]);
                min = Math.min(min, arr[i]);
            }
            i +=2;
        }
        // comparing with for last element if there are odd number of elements in array
        if (arr.length%2==1) {
		min = Math.min(min, arr[arr.length - 1]);
		max = Math.max(max, arr[arr.length - 1]);
	}
        }
        System.out.println("Max is "+max+" min is "+min);
    }
    public static void main(String[] args) {
        int[] arr = {4,2,3,7,8,2,3,1,10};
        minMax(arr);
    }
} 