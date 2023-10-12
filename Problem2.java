// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution
{ 
    public static int findSum(int A[],int N) 
    {
        int min = A[0],max = A[0],i;
        for(i = 1; i < N -1 ; i+=2){
            if(A[i] > A[i+1]){
                max = Math.max(A[i],max);
                min = Math.min(A[i+1],min);
            }
            else{
                max = Math.max(A[i+1],max);
                min = Math.min(A[i],min);
            }
        }
        if(i == N-1){
            max = Math.max(A[i],max);
                min = Math.min(A[i],min);
        }
        return max + min;
    }
}