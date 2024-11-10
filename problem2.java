// Time Complexity : 0(n)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class problem2 {

    public void minmaxEle(int[] arr)
    {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i =0;i<arr.length-1;i++)
        {
            if(arr[i]<arr[i+1])
            {
                min = Math.min(arr[i],min);
                max = Math.max(arr[i+1],max);
            }
            else
            {
                min = Math.min(arr[i+1],min);
                max = Math.max(arr[i],max);
            }
        }
        System.out.println("Minimum element is: " + min);
        System.out.println("Maximum element is: " + max);
    }


}
