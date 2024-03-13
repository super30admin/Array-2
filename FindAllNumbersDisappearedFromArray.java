import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(n)
// Space Complexity : O(1), no extra space used
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your a

public class FindAllNumbersDisappearedFromArray {
    // Time = O(n);
    // Space = O(1), no extra space used
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // temp state change pattern
        if(nums == null) return null;
        List<Integer> result = new ArrayList<Integer>();

        for(int i = 0; i < nums.length; i++){
            int temp = Math.abs(nums[i]) - 1;
            // go to temp index
            // check if its already greater than 0
            if(nums[temp] > 0){
                // if positive, then make it negative
                nums[temp] = nums[temp] * -1;
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0) {
                // means number is positive
                // add it to the result list
                result.add(i + 1);
            } else {
                nums[i] *= -1;
            }
        }
        return result;


    }

}
