package S30.Arrays_2;

/*
Time Complexity : Put: O(n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> result = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) return result;
        //1 should be present at location 0 and so on
        //everytime you encounter a number, mark its index as -* number at that position
        for(int i = 0; i < nums.length; i++){
            int idx = Math.abs(nums[i]) - 1;
            if(nums[idx] > 0)
                nums[idx] = -nums[idx];
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                result.add(i+1); // add the index of the positive element to result
            }else{
                nums[i]*=-1; //else restore array
            }
        }

        return result;
    }
}
