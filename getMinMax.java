// Time Complexity : O(n) 2(n-2)comparisons
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
  static int[] getMinMax(int arr[], int n) {
        int min,max;
        int i;
        int ans = new int[2];
 
        /*If there is only one element then return it as min and max both*/
        if (n == 1) {
            ans[0] = arr[0];
            ans[1] = arr[0];
            return ans;
        }
 
        /* If there are more than one elements, then initialize min 
    and max*/
        if (arr[0] > arr[1]) {
            max = arr[0];
            min = arr[1];
        } else {
            max = arr[1];
            min = arr[0];
        }
 
        for (i = 2; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            } else if (arr[i] < min) {
                min = arr[i];
            }
        }
        ans[0] = min;
        ans[1] = max;
        return ans;
    }
}
