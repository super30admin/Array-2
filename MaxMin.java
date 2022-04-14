class MaxMin
{

    // Time Complexity :0(n)
// Space Complexity :0(1)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : Yes.
    //How to return the min and max variables if the data type is long from below function?


    // Your code here along with comments explaining your approach: I decided to compare pairs of numbers rather than comparing
    //each and every element in the array. This significantly brings down the time to 1.5n from 2n;

    static pair getMinMax(long a[], long n)
    {
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        for(int i = 0; i < n; i+=2){
            if(a[i] > a[i+1]){
                max = Math.max(max, a[i]);
                min = Math.min(min, a[i+1]);
            }
            else{
                max = Math.max(max, a[i+1]);
                min = Math.min(min, a[i]);
            }
        }
        return new long[] {min,max};
    }
}