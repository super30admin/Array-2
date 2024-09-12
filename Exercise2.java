class Solution {
    public static int[] findMinMax(int[] nums) {
        int[] result={nums[0],nums[0]};
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]<result[0]){result[0]=nums[i];}
            else if(nums[i]>result[1]){result[1]=nums[i];}
        }
        return result;
    }
}