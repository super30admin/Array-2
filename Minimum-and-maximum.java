class Solution {
    public int[] minMax(int[] nums){
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        for(int i=0;i<n-2;i+2){
            if(nums[i]> nums[i+1]){
                min = Math.min(min, nums[i+1]);
                max = Math.max(max, nums[i]);
            }else{
                min = Math.min(min, nums[i]);
                max = Math.max(max, nums[i+1]);
            }
        }
        return new int[]{min, max};
    }
}