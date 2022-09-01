// Time Complexity : O(n), but we are making 3n/2 comparisons
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : this problem is from geeks of geeks
// Any problem you faced while coding this : no

public class Problem2 {

    public static int findSum(int A[],int N)
    {
        //code here
        //Brute force approach
        //total comparisions would be 2N
        // int max =0;
        // int min = A[0];
        // int sum =0;


        // for(int i=0; i<A.length; i++){

        //   if(A[i]>max) max = A[i];
        //   if(A[i]<min) min = A[i];
        //   sum = min + max;
        // }



        // return sum;

        //another approach
        //Making 3n/2 comparisions

        int max =0;
        int min = A[0];
        int sum =0;

        for(int i=0; i<A.length-1; i++){


            if(A[i] > A[i+1]){
                max = Math.max(max, A[i]);
                min = Math.min(min, A[i+1]);
            }

            else{

                max = Math.max(max, A[i+1]);
                min = Math.min(min, A[i]);
            }
            sum = max+ min;
        }
        return sum;
    }
}
