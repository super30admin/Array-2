package gfg_MaxAndMinInArray;
//Time complexity : O(N)
//Space Complexity : O(1)
 class Solution {
     public int[] findMinMax(){
         int nums[] = new int[] {22, 14, 8, 17, 35, 3} ;
         int max = nums[0];
         int min = nums[0];

         for(int i=0; i<nums.length; i++){
             if(nums[i]>max){
                 max = nums[i];
             }
             if(nums[i]<min){
                 min = nums[i] ;
             }

         }
         return new int[] {min, max} ;
     }

}
