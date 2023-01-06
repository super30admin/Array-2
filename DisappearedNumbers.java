// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Approach: In this approach we use the same array to mutate. We check if the element corresponding to the index that is present at current value is not negative.
//Then we make it negative. If the current b\value is negative we take abs of it. If the element at the current value index is negative we don't do anything.
//We then do a second pass and add the positive values to the result arraylist which will give us the number disappeared.

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0)return new ArrayList<Integer>();

        List<Integer> result = new ArrayList<Integer>();

        for(int i=0;i<nums.length;i++){
            if(nums[i] >0){
                if(nums[Math.abs(nums[i])-1] > 0){
                    nums[Math.abs(nums[i])-1] *= -1;
                }
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                result.add(i+1);
            }else{
                nums[i] *= -1;
            }
        }
        return result;
    }
}