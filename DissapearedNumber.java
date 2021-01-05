// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new ArrayList<Integer>();
        }
        Set<Integer> found = new HashSet<>();
        for(int i = 0 ; i < nums.length; i++){
            found.add(nums[i]);
        }
        
        List<Integer> notFound = new ArrayList<>();
        for(int i = 1; i <= nums.length; i++){
            if(!found.contains(i)) notFound.add(i);
        }
        
        return notFound;
    }
}