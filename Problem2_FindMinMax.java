// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// To reduce the number of iteration, instantiate min and max with the 0th index element of the array
// Address the base condition by returning the max+min if length of array N==1
// Then to minimize the number of comparisions do the first two elements comparision and assign to min and max respectively
// Now from index 2 iterate through the array and compare in pairs to assign the min and max, so comparisions dropped from 4 to 3
// Total Comparisions = 1 + (n-2/2)*3 + 1(in case of odd length array)

public class Problem2_FindMinMax {
    public static int findSum(int A[],int N) 
    {
        int min=A[0];
        int max=A[0];
        if(N==1) return max+min;
        if(A[0]>A[1]){
            min=A[1];
            max=A[0];
        }else{
            max=A[1];
            min=A[0];
        }
        for(int i=2; i<N && i!=N-1; i+=2){
            if(A[i]<A[i+1]) {
                min=Math.min(min, A[i]);
                max=Math.max(max, A[i+1]);
            }else{
                min=Math.min(min, A[i+1]);
                max=Math.max(max, A[i]);
            }
        }
        if(N%2!=0){
            min=Math.min(min, A[N-1]);
            max=Math.max(max, A[N-1]);
        }
        return max+min;
    }
}
