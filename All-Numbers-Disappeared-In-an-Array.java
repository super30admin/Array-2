## Problem1 (https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums==null || nums.length==0){
            return new ArrayList<>();
        }
        List<Integer> list=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            int index=Math.abs(nums[i])-1;
            if(nums[index] < 0){
                continue;
            }else{
                 nums[index]=nums[index] * -1;
            }
           
        }

        for(int i=0;i<n;i++){
            if(nums[i] < 0){
                continue;
            }
            else{
              list.add(i+1);
            }
        }
        return list;
    }
}