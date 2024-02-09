//TC: O(1.5n+1)
//SC: O(1)
class Solution {
    public int[] min_max(int[] nums) {
        int [] result=new int[2];
        int x=Integer.MAX_VALUE;
        int y=Integer.MIN_VALUE;
         for(int i=0;i<nums.length;i++)
          {
            if(nums[i]<nums[i+1])
             {
               x=Math.min(nums[i],x);
               y=Math.max(nums[i+1],y);
             }
             else

            {
               x=Math.min(nums[i+1],x);
               y=Math.max(nums[i],y);
             }
          }

        if(nums.length%2!=0)
         {
          if(nums[nums.length-1]<x)
            x=nums[nums.length-1]
     if(nums[nums.length-1]>y)
            y=nums[nums.length-1]

         }
result[0]=x;
result[1]=y;
        return result;
    }
}