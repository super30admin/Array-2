import java.util.*;
public class FindMinMax {
    static int[] minAndMax(int[] arr){
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n - 1; i = i +2){
            if(arr[i] > arr[i+1]){
                max = Math.max(max, arr[i]);
                min = Math.min(min,arr[i+1]);
            }
            else{
                max = Math.max(max, arr[i+1]);
                min = Math.min(min,arr[i]);
            }
        }

        if(n%2 != 0){
            max = Math.max(max, arr[n-1]);
            min = Math.min(min,arr[n-1]);
        }
        return new int[] {min,max};

    }
    public static void main(String[] args){
        int[] arr = {7,4,8,3,9,1};
        int[] result = minAndMax(arr);
        System.out.println("The min is " + result[0] + " The max is " + result[1]);
    }
    
}
