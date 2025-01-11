import java.util.ArrayList;
import java.util.List;

/*
Time Complexity -> O(N)
Space Complexity -> O(1)
*/

class Problem1 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        // Logic since it is from 1-> N and need to find the missing element and the
        // index starts
        // from 0 to n-1 this indicates the nums in that index is present so we got that corresponding index and chaneg to -1;
        //So if the number is not present in the array the particular this means there is a duplicate element and id we go to that position it will be already minus
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = nums[index] * -1;
            }
        }
        // Adding positive numbers which contributes to the missing element
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
}