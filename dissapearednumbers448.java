// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    /*
      0 1 2 3 4 5 6 7
    [-4,-3,-2,-7,8,2,-3,-1]
    */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length==0) return new ArrayList<>();
        for (int i = 0;i<nums.length;i++){
            int val = Math.abs(nums[i]);
            if(val<=nums.length){
                if(nums[val-1]>0){
                    nums[val-1] = -1 * nums[val-1];
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i<nums.length;i++){
            if(nums[i]>0){
                res.add(i+1);
            }
        }
        return res;
    }
}
