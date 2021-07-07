// Time Complexity :O(n) n is array length.
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        for(int i=0;i<nums.length;i++){
            int index = Math.abs(nums[i]);
            if(nums[index-1]>0)nums[index-1] *= -1;
        }
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                result.add(i+1);
            }
        }
        
        return result;
        
    }
}