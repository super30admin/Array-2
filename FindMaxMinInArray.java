class Solution
{ 
    public static int findSum(int A[],int N) 
    {
        int max = A[0];
        int min = A[0];
        
        for (int i = 1; i < N; i++) {
            max = Math.max(max, A[i]);
            min = Math.min(min, A[i]);
        }
        
        return min+max;
    }
}