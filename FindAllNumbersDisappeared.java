// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// Using the same array, marked the index of the element changing to a negative
// Then iterate again to if there are positives those index+1 are the missing
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums==null || nums.length==0)
            return new ArrayList<>();
  
        for(int i=0; i< nums.length; i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index] >0){
                nums[index] *= -1; 
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0; i< nums.length; i++){
            if(nums[i] > 0){
                res.add(i+1);
            }
        }
        
        return res;
    }
}