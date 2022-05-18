// Time Complexity : O(n)
// Space Complexity : O(1)
// Number of comparisons : 3*(n/2)= 1.5n < 2n
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// "static void main" must be defined in a public class.
public class Main {
    
    static class Pair {
        int min;
        int max;
    }
    public static Pair getMinMax(int arr[], int size){
        Pair p= new Pair();
        p.min=Integer.MAX_VALUE;
        p.max=Integer.MIN_VALUE;
        int i;
        for(i=0; i<size-1; i++){
            if(arr[i]<arr[i+1]){
                if(arr[i]<p.min) p.min=arr[i];
                if(arr[i+1]>p.max) p.max=arr[i+1];
            }
            else{
                if(arr[i]>p.max) p.max=arr[i];
                if(arr[i+1]<p.min) p.min=arr[i+1];
            }
            i++;
        }
        if(i<size){
            if(arr[i]>arr[i-1]){
                if(arr[i-1]<p.min) p.min=arr[i-1];
                if(arr[i]>p.max) p.max=arr[i];
            }
            else{
                if(arr[i-1]>p.max) p.max=arr[i-1];
                if(arr[i]<p.min) p.min=arr[i];
            }
        }
        return p;
    }
    
    public static void main(String[] args) {
        int arr[] = {1000, 11, 445, 1, 330, 3000, 5000};
        int arr_size = 7;
        Pair minmax = getMinMax(arr, arr_size);
        System.out.printf("\nMinimum element is %d", minmax.min);
        System.out.printf("\nMaximum element is %d", minmax.max);
    }
}
