import java.util.*;

// Time complexity: O(n)
// Space complexity: O(1)
class FindDisappearedNumbers {
    public static void main(String[] args) {
        int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
        List<Integer> result = findDisappearedNumbers(nums);
        System.out.println(result);
    }

    private static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] > 0) {
                nums[idx] *= -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            } else {
                nums[i] *= -1;
            }
        }
        return result;
    }
}