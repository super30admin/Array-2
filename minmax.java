class Solution {
  //TC: O(n) SC:O(1)
    public int[] minMax(int[] nums) {
      int n=nums.length;
      int min=nums[0];
      int max=nums[1];
      if(min>max){
      max=min-(min-max);
      min=max-(max-min);
      }
      
      for(int i=2;i<n;i=i+2)
      {
        //if nums[i] is greater 
        if(nums[i]>nums[i+1]){
          //ifnums[i]> max, them make it max
          if(nums[i]>max){
            max=nums[i];
            }
          //if(nums[i+1] is lesser than min,make it min.
          if(nums[i+1]<min){
            min=nums[i+1];
            }
          
        }
        else{ //if nums[i+1] is greater
        //ifnums[i]> max, them make it max
          if(nums[i+1]>max){
            max=nums[i+1];
            }
          //if(nums[i] is lesser than min,make it min.
          if(nums[i]<min){
            min=nums[i];
            }
          
        }
      }
      result[1]=max;
      result[0]=min;

        return result;
                                            
    }
}
