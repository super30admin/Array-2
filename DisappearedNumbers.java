import java.util.ArrayList;
import java.util.List;
// Time Complexity : O(n) since we will have to iterate over each element in the array
// Space Complexity : O(1) since we are updating the input array in place to mark the presence of an element at index - 1
// Did this code successfully run on Leetcode :Yes
//Approach: Consider the input array as the hash array with 0 based indexing, for every number we encounter,
// we will mark its presence in the array by negating number - 1 index
// In the second pass we will find all the positive indices and add index + 1 to the missing list since this is 0 based indexing
public class DisappearedNumbers {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        final List<Integer> missing = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) nums[index] *= -1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) missing.add(i + 1);
        }

        return missing;
    }

    public static void main(String[] args) {
        final DisappearedNumbers disappearedNumbers = new DisappearedNumbers();
        System.out.println(disappearedNumbers.findDisappearedNumbers(new int[] {4, 3, 2, 7, 8, 1, 2, 3})); //return [5, 6]
        System.out.println(disappearedNumbers.findDisappearedNumbers(new int[] {1, 1})); //return [2]
        System.out.println(disappearedNumbers.findDisappearedNumbers(new int[] {1, 2})); //return []
    }
}
