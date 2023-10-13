

import java.util.ArrayList;
import java.util.List;
//Time Complexity: O(n)
//Space Complexity: O(1)

// Did this code successfully run on LeetCode : Yes
// Any problem you faced while coding this : No

//Approach: Iterate the array change the state of the number's corresponding position element to negative and
// then collect all the positive numbers from the array, which are missing numbers, create the arraylist and return.
// Here we have used the technique of temporary state change.

public class FindDisappearedNumbers {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i : nums) {
            int index = Math.abs(i);  // while iterating the numbers we might have changed it to negative to indicate
                                      // a number with that index is already there somewhere.  To get the real value
                                      // we need to use abs function
            if (nums[index - 1] > 0) {  // going to previous element and check if it is already changed it to negative
                                        // ignore it otherwise change it negative.
                nums[index - 1] *= -1;
            }
        }
        List<Integer> missingNumbersList = new ArrayList<>();
        //loop through the nums array one more time and collect non-negative numbers and which indicates those are missing
        // add it to the results list
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                missingNumbersList.add(i + 1);
            }else{  // change the temporary state of the numbers that are marked as negative to original state. This is not
                    //asked in the leet code though.
                 nums[i] *= -1;
            }
        }
        return missingNumbersList;
    }
    public static void main(String[] args){
        int[] nums = {4,5,2,1,2,7,8,5};
       List<Integer> missedNumbers = findDisappearedNumbers(nums);
       System.out.println(missedNumbers);
    }
}
