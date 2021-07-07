//O(n) time complexity
//O(1) Space complexity
//Ran on leetcode and accepted
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> ret = new ArrayList<Integer>();
    //Iterate over the nums array
    for(int i = 0; i < nums.length; i++) {
        //store the value at index i at val which will be used as index later
        int val = Math.abs(nums[i]) - 1;
        //Check if the abs value of the element at nums[val] is positive
        if(nums[val] > 0) {
            //If positive negate it to mark it as visited
            nums[val] = -nums[val];
        }
    }
    //Iterate through the array again  
    for(int i = 0; i < nums.length; i++) {
        //check if it still contains any positive values
        if(nums[i] > 0) 
        {
            //If there are any positive values it means that particular index value number does not exist in the array 
            //Hence add it to the result list
            ret.add(i+1);
        }
    }
    // return result
    return ret;
}
}