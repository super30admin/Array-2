
/*
def findMinMax(arr):
    n = len(arr)

    if arr is None or n == 0:
        return 
    if n == 1:
        return arr[0], arr[0]

    min_ele = float('inf')
    max_ele = float('-inf')
    if arr[0] > arr[1]:
        max_ele = arr[0]
        min_ele = arr[1]
    else:
        min_ele = arr[0]
        max_ele = arr[1]
    
    for i in range(2, n-1):
        if arr[i] > arr[i+1]:
            max_ele = max(max_ele, arr[i])
            min_ele = min(min_ele, arr[i+1])
        else:
            max_ele = max(max_ele, arr[i+1])
            min_ele = min(min_ele, arr[i])
    if n % 2 == 1:
        max_ele = max(max_ele, arr[n-1])
        min_ele = min(min_ele, arr[n-1])
    
    return max_ele, min_ele
*/
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : n/a
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: I compared the two elements in array with themselves and thereby I could 
// save one comparison per 2 elements 

class Solution{
    public int[] findMinMx(int [] arr){
        n = arr.length; 
        if (arr == null || n == 0){
            return new int[0];
        }
        if (n = 1){
            return new int[] {arr[0], arr[0]};
        }

        if (arr[0] > arr[1]){
            min = arr[1];
            max = arr[0];
        }
        else{
            min = arr[0];
            max = arr[1];
        }

        for (int i=0; i < n-1; i++){
            if (arr[i] < arr[i+1]){
                min = Math.min(min, arr[i]);
                max = Math.max(max, arr[i+1]);
            }else{
                min = Math.min(min, arr[i+1]);
                max = Math.max(max, arr[i]);
            }

        }

        if (n % 2 == 1){
            min = Math.min(min, arr[n-1]);
            max = Math.max(max, arr[n-1]);
        }

        return new int[] {max, min};
    }
}
