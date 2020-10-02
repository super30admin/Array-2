// Time Complexity : O(N) - N is size of the array
// Space Complexity : O(1) - As no additional data structure is being used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) return res;
        for (int i = 0; i < nums.length; i++) {
                 int k = Math.abs(nums[i]) - 1;
                 if(nums[k] > 0){
                     nums[k] = -nums[k];
                 }
            }
        
        for(int i = 0;i < nums.length;i++){
            if(nums[i] > 0){
                res.add(i + 1);
            }
        }
        return res;
    }
}
// Your code here along with comments explaining your approach