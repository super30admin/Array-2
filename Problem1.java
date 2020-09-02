// Time Complexity : O(n) -> n = array length
// Space Complexity : O(n) -> n = hash set size
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// Adding elements in a set
// comparing all elements one by one and then return the result List

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        Set<Integer> set = new HashSet<Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            
            if(!set.contains(nums[i])) {
                set.add(nums[i]);
            } else {
                continue;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++) {
            if(!set.contains(i + 1)) {
                result.add(i + 1);
            }
        }
        
        return result;
    }
}