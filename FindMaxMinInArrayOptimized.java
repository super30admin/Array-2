// Same time and space complexity as regular solution. But in this case we are reducing the number of comparisons 
// from 2N to 1.5N as we are taking elements in pairs. Basically for every pair we have total of 3
// comparisons. If we go with regular approach to find max and min, we will have 2 comparisons for
// every element

class Solution
{ 
    public static int findSum(int A[],int N) 
    {
        int max = A[0];
        int min = A[0];
        
        for (int i = 0; i < N-1; i += 2) {
            if (A[i] > A[i+1]) { // 1 comparison
              max = Math.max(max, A[i]); // 1 comparison
              min = Math.min(min, A[i+1]); // 1 comparison
            }
            else {
              max = Math.max(max, A[i+1]);
              min = Math.min(min, A[i]); 
            }
        }
        
        return min+max;
    }
}