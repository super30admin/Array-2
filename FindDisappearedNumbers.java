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
            int index = Math.abs(i);
            if (nums[index - 1] > 0) {
                nums[index - 1] *= -1;
            }
        }
        List<Integer> missingNumbersList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                missingNumbersList.add(i + 1);
            }else{
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