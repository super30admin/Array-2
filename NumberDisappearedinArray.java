// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // base condition
        if(nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        // add the elements in the set
        for(int i=0;i<nums.length;i++) {
            set.add(nums[i]);
        }
        // check if i+1 is present in the set as we know the length of the array is n so we can traverse through the array and check if the element is present
        for(int i=0;i<nums.length;i++) {
            if(set.contains(i+1) == false) {
                // add into the list if the element is not present
                result.add(i+1);
            }
        }
        return result;
    }
}
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // check the base condition
        if(nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            // find the index and use Math.abs as index can never be negative
            int index = Math.abs(nums[i]);
            if(nums[index-1] < 0) {
                continue;
            }
            nums[index-1] = -1 * nums[index-1];
        }
        for(int i=0;i<nums.length;i++) {
            // check if nums[i] > 0 as the elements which are positive have missing element
            if(nums[i] > 0) {
                result.add(i+1);
            }
        }
        return result;
    }
}
