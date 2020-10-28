// Time Complexity :O(n) + O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> ls = new ArrayList<>();
        
        // edge case
        if(nums == null || nums.length == 0 ) return ls;
        
        // iterate through array
        for(int i=0;i<nums.length; i++){
            
            // abs(element -1)
            int temp = Math.abs(nums[i])-1;
            
            // go to index of temp and make it -ve if +ve
            if(nums[temp] > 0){
                nums[temp] *= -1;
            }
            
        }
        
        // if element is positive take its index +1 and add it to resulr
        for(int i =0;i<nums.length;i++){
            if(nums[i]>0) ls.add(i+1);
        }
        
        return ls;
        
    }
}