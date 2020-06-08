// Time Complexity : O(2n) = O(n), n is size of array
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 


class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        
        for(int i = 1; i <= nums.length; i++) {
            if(!set.contains(i)) {
                list.add(i);
            }
        }
        return list; 
    }
}




