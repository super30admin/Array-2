// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// Calculating first min and max 
// then ierate comparing the value again min or max
public class Solution {
    public int[] minAndMax(int arr[]){
        if(arr==null || arr.length==0)
            return new int[2];
        
        if(arr.length==1)
            return new int[]{arr[0], arr[0]};
        int min, max;
        if(arr[0] > arr[1]){
            min = arr[1];
            max = arr[0];
        }else{
            min = arr[0];
            max = arr[1];
        }
        
        for(int i=2; i<arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }else if(arr[i] < min){
                min = arr[i];
            }
        }
        return new int[]{min, max};
    }
    
    public static void main(String[] args) {
        int arr[] = {2,4,5,3,7,1,10,9,6};
        int res[] = new Solution().minAndMax(arr);
        System.out.println(res[0] + " " + res[1]);
    }
}