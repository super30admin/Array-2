// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        //null check
        if(nums == null || nums.length == 0)
            return result;

        for(int i=0;i<nums.length;i++){
            int idx = Math.abs(nums[i]) -1;
            if(nums[idx] > 0){
                nums[idx] *= -1;
            }
        }
        for(int i =0;i<nums.length;i++){
            if(nums[i]>0){
                result.add(i+1);
            }
            else{
                nums[i] *= -1;
            }
        }
        return result;
    }
}