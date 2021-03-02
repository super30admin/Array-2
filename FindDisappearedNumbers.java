// to find the missing number, since we know array consists of only elements from 1 to n, we can traverse through the array and change the element 
// present at index nums[i]-1 to negative of the element present there

// when we traverse the array once again, the index where the elements are missing are the once that are missing in the given input. 

// Time Complexity : O(n)
// Space Complexity : O(1)

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindDisappearedNumbers {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<int[]> inputs = new ArrayList<>();
        Collections.addAll(inputs, new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }, new int[] { 2, 3, 1, 1, 1, 6 }, new int[] {});

        for (int[] nums : inputs) {
            System.out.println(findDisappearedNumbers(nums).toString());
        }
    }
}