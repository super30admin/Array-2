// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> result = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            int temp = Math.abs(nums[i]);
            if(nums[temp-1]>0){
                nums[temp-1] = nums[temp-1]*-1;
            }
            
        }
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                result.add(i+1);
            }
        }

        return result;
    }
}