// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

// logic: Iterate through the array, for each number nums[i], mark its corresponding index index = abs(nums[i]) - 1 as negative to indicate the presence of that number in the array.
// Iterate through the array again, adding the index + 1 to the result list for any positive value, which indicates the corresponding number was not marked and thus is missing.
// The list of numbers which were not marked in the array is returned as the result.

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();

        for(int i =0; i< nums.length; i++){
            int index = Math.abs(nums[i]) -1;
            if( nums[index] > 0){
                nums[index]= nums[index] * -1;
            }
        }

        for( int i =0; i < nums.length; i++){
            if(nums[i] > 0){
                result.add(i+1);
            }
            else{
                nums[i] = nums[i] * -1;
            }
        }

        return result;



    }
}