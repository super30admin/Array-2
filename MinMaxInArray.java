// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes on GFG
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 1: We consider the array in pairs and calculate the min/max between each pair
// 2: Through this approach, instead of 2n comparisons, we do 1.5n comparisons
// 3: For odd length array, we start the array at int 1 instead of 2
class Solution {
    public ArrayList<Integer> getMinMax(int[] arr) {
        int n = arr.length;
        int min = 0, max = 0;
        int i = 0;

        // Initialize min and max
        if (n % 2 == 1) {
            min = arr[0];
            max = arr[0];
            i = 1;
        } else {
            if (arr[0] < arr[1]) {
                min = arr[0];
                max = arr[1];
            } else {
                min = arr[1];
                max = arr[0];
            }
            i=2;
        }

        // Process elements in pairs
        for(; i<n; i+=2){
            if(arr[i] > arr[i+1]){
                max = Math.max(max, arr[i]);
                min = Math.min(min, arr[i+1]);
            }
            else{
                max = Math.max(max, arr[i+1]);
                min = Math.min(min, arr[i]);
            }

        };
        return new ArrayList<>(Arrays.asList(min, max));
    }
}
