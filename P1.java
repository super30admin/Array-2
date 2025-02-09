// Time Complexity :    O(n)
// Space Complexity :   O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    None


// Your code here along with comments explaining your approach  - Mark the indices of all elements that have appeared as -1 , then just check which indices are still positive. Those numbers are missing


class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i ++) {
            int idx = Math.abs(nums[i]) - 1;    //zero based indexing 
            if (nums[idx] > 0) {
                nums[idx] *= -1;    //mark as -ve
            }
        }
        for (int i = 0; i < n; i ++) {
            //positive
            if (nums[i] > 0) {  //if index is +ve add that to the result list
                result.add(i + 1);
            } else {
                nums[i] *= -1;  // if not mark as -ve
            }
        }
        return result;
    }
}
