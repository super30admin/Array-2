// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes - on  geekforgeeks
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//take each element as a pair, find the max and min value. repeat the process
//to get the max and min for the whole array
class Problem2
{
    public static int findSum(int A[],int N)
    {
        //code here
        int max=A[0];
        int min=A[0];
        //code here.
        for(int i =0 ;i<A.length-1;i+=2){
            if(A[i] < A[i+1]){
                min = Math.min(min,A[i]);
                max = Math.max(max,A[i+1]);
            } else {
                max = Math.max(max,A[i]);
                min = Math.min(min,A[i+1]);
            }
        }
        if(A.length %2 ==0)
            return max+min;
        else
            return Math.max(max,A[A.length-1])+Math.min(min,A[A.length-1]);
    }
}
