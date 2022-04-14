// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

/*

Rather than comparing with all the elements over here, 3 elements are 
compared for n/2 iterations. 

*/

public class MaximumAndMinimum{
    
    public static int[] MaxMin(int[] arr)
    {
        if(arr==null || arr.length==0)
        {
            return new int[]{};
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int i =0;
        while(i<arr.length-1)
        {
            if(arr[i]<arr[i+1])
            {
                min=Math.min(min, arr[i]);
                max= Math.max(max, arr[i+1]);
            }
            else{
                min = Math.min(min, arr[i+1]);
                max= Math.max(max, arr[i]);
            }
        }

        int[] ans = new int[2];
        ans[0]=min;
        ans[1]=max;
        return ans;
    }


    public static void main(String args[])
    {
        int[] arr = {1000, 11, 445, 1, 330, 3000};
        int[] ans = MaxMin(arr);
        System.out.println(ans[0]+" "+ans[1]);
    }
}
