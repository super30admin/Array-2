// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

// Your code here along with comments explaining your approach
/*
This problem can also be solved by maintaining a boolean array and marking that nums[i] - 1 as true and
return all those elements which remain false by traversing the boolean array again. But, the space complexity
will be O(n) for boolean array.So, to optimize, we traverse through input array and make the nums[i] - 1
index's value as negative(if not). Finally, we return all those values which remain positive(means their
index not being called as that value is not present). We need to make sure of taking absolute value while
computing index as there is a chance of revisiting the indices during traversal.
 */
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> disappearedList = new ArrayList<>();
        int len = nums.length;
        for(int i = 0 ; i < len ; i++) {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0)
                nums[index] *= -1;
        }
        for(int i = 0 ; i < len ; i++) {
            if(nums[i] > 0)
                disappearedList.add(i + 1);
        }
        return disappearedList;
    }
}