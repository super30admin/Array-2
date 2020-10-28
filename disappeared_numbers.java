// Time Complexity : O(n), where n is the size of the nums array
// Space Complexity :O(1), we are not using extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();
        
        //if nums array is empty or null return result
        if(nums == null || nums.length == 0) return result;
        
        //Iterate over the nums array
        for(int i =0; i< nums.length; i++){
            //calculate the index
            int index = Math.abs(nums[i]) -1;
            //if the value at the calculated index is greater than 0
            if(nums[index] > 0){
                //make the value negative
                nums[index] *= -1;
            }
        }
        
        //Iterate over the nums array once again
        for(int i=0; i<nums.length; i++){
            //if the value is positive
            if(nums[i] > 0){
                //add the current index +1 to the result as it is the missing value
                result.add(i+1);
            }
        }
        //return the result
        return result;
    }
}