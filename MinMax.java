// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution
{ 
    public static int findSum(int A[],int N) 
    {
        //code here
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int num : A){
            if(num < min) min = num;
            else max = Math.max(max, num);
        }
        return min+max;
    }
}