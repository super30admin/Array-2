// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Comparing in pairs 
 * Edge case: Odd length
 *  */ 
class Solution {
    public ArrayList<Integer> getMinMax(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, i =0;
        int n = arr.length;
        if(n % 2 == 1){ // for odd length, set min & max as the first element 
            min = arr[i];
            max = arr[i];
            i = 1;
        }
        while (i < n-1){
            if(arr[i] > arr[i+1]){
                max = Math.max(max, arr[i]);
                min = Math.min(min, arr[i+1]);
            }else{
                max = Math.max(max, arr[i+1]);
                min = Math.min(min, arr[i]);
            }
            i+=2;
        }
        result.add(min);
        result.add(max);
        return result;
    }
}
