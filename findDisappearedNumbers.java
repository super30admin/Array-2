// Time Complexity :o(n)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nop

// here we are trying to use the relation of index with the numbers in array as given
// we know that array contains 1 to arraylength numbers

// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        int index = 0;
        for(int i = 0; i < nums.length; i++) {
            index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0) {
            nums[index] = nums[index] * -1; // this check is necessary, what if array has duplicate elements
            // we will end up making it positive!
            }      
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
}