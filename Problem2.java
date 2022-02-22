// Time Complexity : O(n) where n = length of array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.*;
public class Problem2 {

    public static int[] getMinMax(int[] arr) {
        int n = arr.length;
        // ans[0] = min, ans[1] = max
        int[] ans = new int[2];
        int i;
        // If size of array is odd, set initial min and max as first element in the array
        if (n%2 == 1) {
            ans[0] = arr[0];
            ans[1] = arr[0];
            // Set pointer to 2nd index (i = 1)
            i = 1;
        } else { // If size of array is even, set initial min and max as min(first element, second element) and max(first element, second element) respectively
            ans[0] = Math.min(arr[0], arr[1]);
            ans[1] = Math.max(arr[0], arr[1]);
            // Set pointer to 3rd index (i = 2)
            i = 2;
        }
        // Make pairs and compare among each other and then with min and max
        while(i < n-1) {
            if (arr[i] < arr[i+1]) {
                ans[0] = Math.min(ans[0], arr[i]);
                ans[1] = Math.max(ans[1], arr[i+1]);
            } else {
                ans[0] = Math.min(ans[0], arr[i+1]);
                ans[1] = Math.max(ans[1], arr[i]);
            }
            i += 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1000, 11, 445, 1, 330, 3000};
        int[] ans = getMinMax(arr);
        System.out.println(Arrays.toString(ans));
    }


}
