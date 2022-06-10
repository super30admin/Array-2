class Solution 
  //tC O(n)sc: O(1)
    public List<Integer> findDisappearedNumbers(int[] nums) {
         for(int i=0; i<nums.length; i++) {
            int temp = Math.abs(nums[i]);
            
            if(nums[temp-1] > 0) {
                nums[temp-1] = nums[temp-1] * -1;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > 0) {
                result.add(i+1);
            }
        }
        return result;
    }
}
