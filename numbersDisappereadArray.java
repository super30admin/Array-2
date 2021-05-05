//Time Complexity : O(n)
//Space Complexity : O(1) no extra space used
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        for(int i = 0; i < nums.length; i ++){
            
            int index = Math.abs(nums[i]);
            
            if(nums[index-1] > 0){
                
                nums[index-1] = nums[index-1] * -1; 
            }
        }
        
        List<Integer> arr = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i ++){
            
            if(nums[i] > 0){
                
                arr.add(i+1);
            }
        }
        
        return arr;
        
    }
}