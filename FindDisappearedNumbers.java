// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We traverse through the array and for each 'index', we make the element present at nums[index] - 1 negavtive if its positive
// We traverse through the array again and for each element that is positive, we add the index+1 for that element to the result, if the element is negative we make it postive again
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        if(nums == null || nums.length == 0)
            return result;
        
        int index = 0;
        for(int i=0; i<nums.length; i++) {
            index = Math.abs(nums[i])-1;
            if(nums[index] > 0) {
                nums[index] *= -1;
            }
        }
        
        for(int i=0; i< nums.length; i++) {
            if(nums[i] < 0) {
                nums[i] *= -1;
            } else {
                result.add(i+1);
            }
        }
        
        return result;
    }
}