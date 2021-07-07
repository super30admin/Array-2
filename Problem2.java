/executed in Leet code
//Time complexity-o(n)
//space complexity -constant

class Solution {
    public int[] findMaxMinNumbers(int[] nums) {
      int max=0,min=0;
           if(nums[0]>nums[1]){
               max=nums[0];
               min=nums[1];
           }else{
               max=nums[1];
               min=nums[0];     
           }
           
           for(int i=2;i<nums.length;i++){
               if(nums[i]>max) {
                   max=nums[i];
               }else{
                   if(nums[i]<min){
                      min=nums[i];
                   }
               }
           }
           
           return new int[]{min,max};
    }
}
