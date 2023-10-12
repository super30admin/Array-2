// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int idx = Math.abs(nums[i])-1;
            if(nums[idx]>0)
                nums[idx]*=-1;
        }
        for(int i = 0; i < n; i++){
            if(nums[i] > 0)
                ans.add(i+1);
        }
        return ans;
    }
}