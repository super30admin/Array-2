// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : no (not availabel on leetcode)
// Any problem you faced while coding this : no
// Approach : Compare elements in paris to reduce number of comparions
public class MinMaxInArray {
    static int min, max;
    static void findMinMax(int arr[]){
        int n = arr.length;
        int i =0;
        if(n%2==0){
            min = Math.min(arr[0], arr[1]);
            max = Math.max(arr[0], arr[1]);
            i+=2;
        }
        else{
            max = arr[0];
            min = arr[0];
            i+=1;
        }
        while(i<n){
            if(arr[i]<arr[i+1]){
                min = Math.min(min, arr[i]);
                max = Math.max(max, arr[i+1]);
            }
            else{
                min = Math.min(min, arr[i+1]);
                max = Math.max(max, arr[i]);
            }
            i+=2;
        }
    }
    public static void main(String args[]){
        int arr[] = new int[]{1,5,2,4,3};
        findMinMax(arr);
        System.out.println(min+" "+max);
    }    
}
