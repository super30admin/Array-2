// Min and Max in Array
// Ran on leetcode: Yes
// TC: O(n) SC:O(1)
/*
In case of even length array set the first two element as min and max, and in case of odd only first element as both min and max.
Use sliding window of size 2 to do comparision to check if the current max is max and current min is min or update them.
*/
class Solution2 {
    public Pair<Integer, Integer> getMinMax(int[] arr) {
        // Code Here
        int arrLen = arr.length;
        int min = 0, max = 0, startIdx = 0;
    
        if(arrLen % 2 == 0){ // Even length array
            if(arr[0] > arr[1]){
                max = arr[0];
                min = arr[1];
            } else {
                max = arr[1];
                min = arr[0];
            }
            startIdx = 2;
        } else { // Odd length array
            min = max = arr[0];
            startIdx = 1;
        }
        
        // Use sliding window of size 2 and check if we have new max or min
        while(startIdx < arrLen - 1){
            if(arr[startIdx] > arr[startIdx+1]){
                max = Math.max(arr[startIdx], max);
                min = Math.min(arr[startIdx+1], min);
            } else {
                min = Math.min(arr[startIdx], min);
                max = Math.max(arr[startIdx+1], max);
            }
            startIdx += 2;
        }
        
        return new Pair<>(min, max);
    }
}