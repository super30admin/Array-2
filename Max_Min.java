//TimeComplexity O(n)
//SpaceComplexity O(1)

Class Solution{
  public int[] maxMinArray(int[] nums){
    int low = 0;
    int high = 1;
    int max = nums[low];
    int min = nums[low];
    while(high < nums.length){
    if(nums[low] > nums[high]){
      max = Math.max(max,nums[low]);
      min = Math.min(min,nums[high]);
  }else{
      max = Math.max(max,nums[high]);
      min = Math.min(min,nums[low]);
    }
    low = low+2;
    high = high+2;
    }
    if(nums.length%2 != 0){
    max = Math.max(max,nums[low]); //Last comparision if the number of elements are odd
    min = Math.min(min,nums[low]); //Last comparision if the number of elements are odd
    }
    
    return new int[] {max,min};
}
}
