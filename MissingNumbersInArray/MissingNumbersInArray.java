/* Time Complexity : O(n)
 * 	n - length of the input array - nums */
/* Space Complexity : O(1) */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :

import java.util.*;


public class MissingNumbersInArray {
	public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> li = new ArrayList();
        if(nums == null || nums.length == 0){ 
            li.add(0);
            return li;
        }

        int n = nums.length;
        for(int i = 0; i < n; i++){
            //get corresponding index for the value
            int index = Math.abs(nums[i]) - 1;
            //If value at that index is greater than '0' multiply it by'-1' ==> number is present somewhere in the array.
            if(nums[index] > 0){
                nums[index] *= -1;
            }
        }
        //to get the missing numbers list
        for(int i = 0; i < n; i++){
            //If value at index is positive ==> index+1 number is missing from the arr, add it to list
            if(nums[i] > 0){
                li.add(i+1);
            }else{//revert back to original array ==> multiply the value at index by '-1' 
                nums[i] *= -1;
            }
        }
        return li;
    }
}
