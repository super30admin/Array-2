// Before class 
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//looping over the array 2 times one for finding the min and one for finding the max
//storing the min in arr[0] and max in arr[arr.length-1] 

class Solution {
    public Pair<Long, Long> getMinMax(int[] arr) {
        // Code Here
        for(int i = 1;i<arr.length;i++){
            int temp = arr[i];
            if(temp<arr[0]){
                arr[i] = arr[0];
                arr[0] = temp;
            }
        }
        for(int i =0;i<arr.length-1;i++){
            int temp = arr[i];
            if(temp>arr[arr.length-1]){
                arr[i] = arr[arr.length-1];
                arr[arr.length-1] = temp;
            }
        }
        return new Pair(arr[0], arr[arr.length-1]);
    }
}