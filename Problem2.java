
//Time complexity= O(N)
//Space Complexity=O(1)
class Solution
{
    public static int findSum(int A[],int N)
    {
        //code here

        int min, max;
        if(N==1){
            return 2*A[0];
        }
        //code here.
        //initialising min and max based on array size
        if(N%2 == 0){
            min = A[0];
            max = A[1];

            for( int i=1; i<N/2; i++){
                int localmin, localmax;
                if(A[2*i]<=A[2*i+1]){
                    localmax = A[2*i+1];
                    localmin = A[2*i];
                }else{
                    localmax=A[2*i];
                    localmin = A[2*i+1];
                }
                if(localmin< min)min=localmin;
                if(localmax>max)max=localmax;
            }
        }else{
            min= max = A[0];

            for( int i=1; i<(N+1)/2; i++){
                int localmin, localmax;
                if(A[2*i]<=A[2*i-1]){
                    localmax = A[2*i-1];
                    localmin = A[2*i];
                }else{
                    localmax=A[2*i];
                    localmin = A[2*i-1];
                }
                if(localmin< min)min=localmin;
                if(localmax>max)max=localmax;
            }
        }

        //make pairs and compare between them




        // min= Math.min(localmin,min);
        // max= Math.max(localmax,max);
        //if(localmin< min)min=localmin;
        //if(localmax>max)max=localmax;


        return min+max;
    }
}