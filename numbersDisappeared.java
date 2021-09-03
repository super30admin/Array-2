// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // intialize to list of integers to be returned
        List<Integer> list = new ArrayList<>();
        // return empty list if input array is null or empty
        if(nums == null || nums.length == 0) return list;
        for(int i = 0; i < nums.length; i++){
            // get index for corresponding to the number occurred
            int index = Math.abs(nums[i]) - 1;
            // if the number at that index is positive, mark it as negative
            if(nums[index] > 0){
                nums[index] *= -1;
            }
        }
        for(int i = 0; i < nums.length; i++){
            // again traverse through the array
            // insert the remaining positive elements in the list
            if(nums[i] > 0) list.add(i + 1);
            // make the negative elements positive again
            else nums[i]*= -1;
        }
        return list;
    }
}