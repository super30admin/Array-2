
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :  Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();

        // go through each element and negate the value present on that index
        for(int i = 0 ; i < nums.length; i++){
            // we need to take the absolute value as it could have been converted to -ve value already
            int temp = Math.abs(nums[i]) - 1;
            if(nums[temp] > 0)
                nums[temp] = nums[temp] * -1;
        }

        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] > 0){
                res.add(i + 1);
            }
        }
        return res;
    }
}