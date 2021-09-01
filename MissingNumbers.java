// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/**
 * First we need to set the index of number found in iteration to negetive and as there are repeated numbers we will not be able to 
 * set all the numbers in the array to negetive
 * Here we can used the index of positives in the array and increment it by 1 to get the real missing numbers
 */
import java.util.ArrayList;
import java.util.List;

/**
 * MissingNumbers
 */
public class MissingNumbers {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> lst = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int index = nums[i] - 1 < 0 ? (-(nums[i]) - 1) : nums[i] - 1;
            if (nums[index] > 0) {
                nums[index] = -(nums[index]);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                lst.add(i + 1);
            }
        }
        return lst;
    }

    public static void main(String[] args) {
        MissingNumbers ms = new MissingNumbers();
        int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
        System.out.println(ms.findDisappearedNumbers(nums).toString());
    }
}