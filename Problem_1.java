// Find All Numbers Disappeared in an Array
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Approach
// If a number is present inside the list, go to its corresponding index & if it's positive, make it negative. The logic to mark it negetive is the tricky part which is the STATE CHANGE Pattern.
// Again traverse the list and we will find some indices whose elements are not negative. So the missing number is (index+1) and store it in result.
// Also, it's a good practice to return the original array, so if an element is negative multiply by -1.

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for(int i= 0; i< nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if(nums[idx] > 0) {
                nums[idx] *= -1;
            }
        }
        for(int i= 0; i< nums.length; i++) {
            if(nums[i] > 0)
                result.add(i+1);
            else
                nums[i] *= -1;
        }
        return result;
    }
}