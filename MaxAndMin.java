// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class MaxAndMin{
    public int[] maxAndMin(int[] arr){
        if(arr == null || arr.length == 0){
            return new int[] {-1, -1};
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(int i=0; i<arr.length; i+=2){
            if(i+1 < arr.length && arr[i] > arr[i+1]){ 
                max = Math.max(max, arr[i]);
                min = Math.min(min, arr[i+1]);
            }
            else if(i+1 < arr.length && arr[i] < arr[i+1]){
                max = Math.max(max, arr[i+1]);
                min = Math.min(min, arr[i]);
            }
            else{
                max = Math.max(max, arr[i]);
                min = Math.min(min, arr[i]);
            }
        }
        return new int[] {max, min};
    }
}