// Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) comparison

// Time Complexity : O(n) 
// Space Complexity : O(1) 
// Did this code successfully run on GFG : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, take max and min initially. Take a pair wise integers in array and find max among those 2 and find max from the max of 2 numbres and
 * previous max and same for min. If the array length is negative get max from previous max and last element and min from previous min and last
 * element and return min and max.
 */

class Solution {
    public Pair<Integer, Integer> getMinMax(int[] arr) {
        // Code Here
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int n = arr.length;
        for(int i = 0; i< n-1;i+=2){
            if(arr[i]>arr[i+1]){
                max= Math.max(max,arr[i]);
                min = Math.min(min, arr[i+1]);
            }
            else{
                max= Math.max(max,arr[i+1]);
                min = Math.min(min, arr[i]);
            }
        }
        if(n%2 == 1){
            max = Math.max(max, arr[n-1]);
            min = Math.min(min, arr[n-1]);
        } 
        return new Pair<>(min,max);
    }
}