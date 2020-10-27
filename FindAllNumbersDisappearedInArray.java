// Time Complexity : O(n) where  n = size of the array
// Space Complexity : O(1) not extra auxiliary space used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*Approach
 * Idea to solve the problem is  to  temp change the  state of the input array to store the nums which are present by
 * negating the index fo that number in the input array. Then find the missing numbers by traversing the array where value at the
 * index is greater the 0. Lastly update the input array to revert back to original state*/

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length==0) return res;

        //Pass 1 to find the index for the corresponding input number
        for(int i=0;i<nums.length; i++){
            //Take abs value to make sure we avoid the negative value
            int index = Math.abs(nums[i])-1;
            //if the value is already negative, we avoid the step
            if(nums[index]>0){
                nums[index] *=-1;
            }
        }
        //Pass 2 to find the missing number and make input back to original state
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                res.add(i+1);
            }
            else {
                nums[i] *=-1;
            }
        }
        return res;
    }
}
