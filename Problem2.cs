// Time Complexity : O(n) where n is the length of arr
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Solution {
    public List<int> getMinMax(int[] arr) {
        // code here
        List<int> result = new();
        int min = 0, max = 0;
        int i;
        
        if(arr.Length % 2 != 0)
        {
            min = arr[0];
            max = arr[0];
            i=1;
        }
        
        else
        {
            min = Math.Min(arr[0], arr[1]);
            max = Math.Max(arr[0], arr[1]);
            i=2;
        }
        
        
        while(i<arr.Length)
        {
            if(arr[i] < arr[i+1])
            {
                min = Math.Min(arr[i], min);
                max = Math.Max(arr[i+1], max);
            }
            
            else
            {
                min = Math.Min(arr[i+1], min);
                max = Math.Max(arr[i], max);
            }
            
            i+=2;
        }
        
        result.Add(min);
        result.Add(max);
        return result;
    }
}
