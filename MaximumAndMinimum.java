public class MaximumAndMinimum {
    public int findMax(int[] nums)
    {
        int max = 0;
        if(nums==null || nums.length==0)
            return 0;
        for(int i =0;i<nums.length-1;i++)
        {
            if(nums[i]>=nums[i+1])
            {
                max = Math.max(max, nums[i]);
            }
            else
            {
                max = Math.max(max, nums[i+1]);
            }
        }
        return max;
    }
    public int findMin(int[] nums)
    {
        int min = Integer.MAX_VALUE;
        if(nums==null || nums.length==0)
            return 0;
        for(int i =0;i<nums.length-1;i++)
        {
            if(nums[i]>=nums[i+1])
            {
                min = Math.min(min,nums[i+1]);
            }
            else
            {
                min = Math.min(min,nums[i]);
            }
        }
        return min;
    }
    public static void main(String args[])
    {
        int[] nums = {7,3,4,5,5,5,6,8,100};
        MaximumAndMinimum ob = new MaximumAndMinimum();
        System.out.println("Maximum is" + ob.findMax(nums));
        System.out.println("Minimum is" + ob.findMin(nums));

    }
}

//time complexity is O(N)
//space is O(1)
