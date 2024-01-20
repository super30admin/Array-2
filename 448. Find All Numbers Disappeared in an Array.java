// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new LinkedList<>();

        for(int foo: nums){
            int num = Math.abs(foo);
            nums[num-1] = -1 * Math.abs(nums[num-1]);
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > -1) {
                result.add(i+1);
            }
        }
        return result;
    }
}
