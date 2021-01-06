// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No, cannot find in problem in leetcode
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// if update max if element id greater than max. If element is greater than max then we do not have to check for min.
// else check for min.


public void MaxAndMinInArray(int[] arr){
    if(arr == null || arr.length == 0) return;
    int min = arr[0];
    int max = arr[0];
    for(int  i = 0; i < arr.length; i++){
        if(arr[i]>max) max = arr[i];
        else if(arr[i]<min) min = arr[i];
    }
    System.out.println("Min : " + min + " Max : " + max);
}