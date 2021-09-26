// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// go the the value of the index and make it -ve as a flag
// check for the values whose flag is not -ve add it to the result
// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList <>();
        if(nums == null || nums.length == 0) return result;
        // flaging the numbers
        for(int i = 0 ; i < nums.length; i++ ){
            int index = Math.abs(nums[i])-1;
            if(nums[index] > 0){
                nums[index] = nums[index] * (-1);
            }
        }
        // reversing the flag
        for(int i = 0; i< nums.length; i++){
            if(nums[i] < 0){
                nums[i] = nums[i] * (-1);
            }else{
                result.add(i+1);
            }
        }
        // result
        return result;
    }
}


