// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//For every value in array we will go to the index in the array whose index=value.
//We will make the value at that location negative.
// We will repeat this process for all the elements in the array
// We will take care of the case where the number is already made -1 and not make it positive
//Now we will traverse form 1 to n and see if the value in the corresponding index in array is negative or not
//If they are not negative it means that the no. was not present and we will add to the answer list
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int l = nums.length;
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < l; i++){
            int num = Math.abs(nums[i]) - 1;
           
            if(nums[num] > 0)
            nums[num] *= -1;    
        }
        for(int i = 0; i < l; i++){
            if(nums[i] > 0){
                res.add(i+1);
            }
        }
        return res;
    }
}