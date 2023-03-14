// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : NA
// Any problem you faced while coding this : No
class Solution2
{
    public static int findSum(int A[],int N)
    {
        //code here
        int min = Integer.MAX_VALUE-1;
        int max = Integer.MIN_VALUE+1;
        int i = 0;
        while( i < (N-1)) {
            if(A[i] < A[i+1]) {
                min = Math.min(min, A[i]);
                max = Math.max(max, A[i+1]);
            } else {
                min = Math.min(min, A[i+1]);
                max = Math.max(max, A[i]);
            }
            i = i + 2;
        }
        if( N%2 != 0) {
            min = Math.min(min, A[N-1]);
            max = Math.max(max, A[N-1]);
        }
        return (min+max);
    }
}

