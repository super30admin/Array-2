// Time Complexity :O(3/2n-2)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Divide and Conquer

//Note: We return integer  array where first array respresent min and second represent max
class MaxMin
{
    public  int[] findMaxMin(int[] nums)
    {
        //edge case
        if(nums==null || nums.length==0) return null;
        return maxmin(nums,0,nums.length-1);
    }
    private  int[] maxmin(int[] arr,int l, int h)
    {
        //base case
        int length = h-l +1;
        if(length<=2)
        {
            if(length==1) return new int[]{arr[l],arr[l]};
            else{
               
                if(arr[l]<arr[l+1])
                    return new int[]{arr[l],arr[l+1]};
                else{
                    return new int[]{arr[l+1],arr[l]};
                }
            }
        }

        int m = l+(h-l)/2; // midpoint
        int[] a = maxmin(arr, l, m);
        int[] b = maxmin(arr, m+1, h);
        return merge(a,b);
    }
    private int[] merge (int[] a, int[] b)
    {
        return new int[]{Math.min(a[0],b[0]),Math.max(a[1],b[1])};
    }
    public static void main(String [] args)
    {
        int[] result = new MaxMin().findMaxMin(new int[]{1,2,3,7,5,9,0});
        System.out.printf("Max is %d\n",result[1]);
        System.out.printf("Min is %d",result[0]);
    }
}