class Solution {
    public List<Integer> findMaxAndMin(int[] nums) {
      int max = nums[0];
      int min = nums[0];
      for (int i=0 ; i<n-1; i++){
          if(nums[i]<nums[i+1]){
            max = Math.max(max, nums[i+1]);
            min = Math.min(min, nums[i]);
          }
          else{
              max = Math.max(max, nums[i]);
              min = Math.min(min, nums[i+1]);
          }
        
    }
      int[] result = new int[];
      result.add(max);
      result.add(min);
      return result;
}
