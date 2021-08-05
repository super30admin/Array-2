
//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
/*
Time: O(n) where n=nums.length
Space: O(1) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
import java.util.ArrayList;
import java.util.List;

public class DisappearedNumbers {

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int newIndex = Math.abs(nums[i]) - 1;

            if (nums[newIndex] > 0)
                nums[newIndex] *= -1;
        }
        List<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++)
            if (nums[i] > 0)
                result.add(i + 1);

        return result;
    }

}
