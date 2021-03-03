// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        if(nums == null || nums.length == 0) return result;
        //at every index, marking nums[i]-1 as negative
        for(int i=0; i<nums.length; i++) {
            int index = Math.abs(nums[i])-1;
            if(nums[index]>0){
                nums[index] *= -1;
            }
        }
        //return numbers corresponding to indices with positive values
        for(int i=0; i<nums.length; i++) {
            if(nums[i]>0) {
                result.add(i+1);
            }
        }
        
        return result;
    }
}