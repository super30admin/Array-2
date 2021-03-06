// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
public class Solution{
    static class Pair{
        int min;int max;
    }
    static Pair getMinMax(int arr[],int n){
        Pair minmax = new Pair();
        int i = 0;
        minmax.max = arr[0];
        minmax.min = arr[0];
        if(n==1 )
        {
            return minmax;
        }
        for(i = 0; i<n-1; i=i+2){
            if(i+1>=n){
              System.out.println(i);
               if(minmax.max < arr[i]){
                    minmax.max = arr[i];
                } 
                if(minmax.min>arr[i]){
                    minmax.min = arr[i];
                } 
                return minmax;
            }
            if(arr[i]>arr[i+1]){
                if(minmax.max < arr[i]){
                    minmax.max = arr[i];
                }
                if(minmax.min>arr[i+1]){
                    minmax.min = arr[i+1];
                }
            }
            else
            {
                if(minmax.max < arr[i+1]){
                       minmax.max = arr[i+1]; 
                }
                if(minmax.min>arr[i]){
                    minmax.min = arr[i];
                }  }
        }
    return minmax;
    }
    public static void main(String args[]) {
        int arr[] = {1000, 11, 445, 1, 330};
        int arr_size = 5;
        Pair minmax = getMinMax(arr, arr_size);
        System.out.printf("\nMinimum element is %d", minmax.min);
        System.out.printf("\nMaximum element is %d", minmax.max);
 
    }
}