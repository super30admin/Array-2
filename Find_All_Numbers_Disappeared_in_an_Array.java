// TC : O(n)
// SC : O(1)

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        if(nums == null || nums.length == 0) return new ArrayList<Integer>();
        
        List<Integer> result = new ArrayList<Integer>();
        int idx = 0;
        for(int i = 0; i < nums.length; i++) {
            
            if (nums[i] > 0) {
                idx = nums[i] - 1;
                if(nums[idx] > 0)
                    nums[idx] = -nums[idx];
            }
            else {
                idx = Math.abs(nums[i]) - 1;
                if(nums[idx] > 0)
                    nums[idx] = -nums[idx];
            }            
        }
        
        for(int i = 0; i < nums.length; i++) {
            
            if(nums[i] > 0) {
                result.add(i+1);
            }
            
        }
        return result;
    }
}
