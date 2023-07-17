// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes on geeksforgeeks
// Any problem you faced while coding this : no


//if number of elemnts are even, start from i=2
//if number of elements are odd, start from i =1
//Using 2 pointers find min and max
class Solution
{ 
    public static int findSum(int A[],int N) 
    {
        if (N==0) return 0;
        if(N == 1) return A[0]+A[0];
        int i =0; int min, max;
        if(N%2 == 0) {
            min = Math.min(A[i], A[i+1]);
            max = Math.max(A[i], A[i+1]);
            i=2;  
        }else{
            min = A[i];
            max = A[i];
            i=1;
        }

        while(i<N){
            
            if(A[i] <A[i+1]) {
                min = Math.min(A[i], min);
                max = Math.max(A[i+1], max);
                
            }else{
                min = Math.min(A[i+1], min);
                max = Math.max(A[i], max);
            }
            i= i+2;
        }
        
        int sum = min+max;
        return sum;
    }
}