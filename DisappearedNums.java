import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

public class DisappearedNums {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> output = new ArrayList<>();

        // get the index by calculating the absolute value of the element. 
        // Since the element value cannot be greater than length of nums and is always positive, we will set the value at that index to be a negative number. the only indexes to remain positive will the ones where the corresponding elements do not exist
        for(int num : nums) {
            int index = Math.abs(num) - 1;

            if(nums[index] > 0) {
                nums[index] = -1 * nums[index];
            }
        }

        for(int i=0; i< nums.length; i++) {
            if(nums[i] > 0) {
                output.add(i+1);
            }
        }

        return output;

    }
}