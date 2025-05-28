// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : none


// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            set.add(nums[i]);
        }
        for(int i = 1; i <= n; i++){
            if(!set.contains((i))){
                ans.add(i);
            }
        }
        return ans;
    }
}
