import java.util.*;

public class DisappearedNumsInArraySolution {
    public List<Integer> findDisappearedNumbersInArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int temp = Math.abs(nums[i]) - 1;
            if (nums[temp] > 0) {
                nums[temp] = nums[temp] * -1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;

    }

    public static void main(String[] args) {
        DisappearedNumsInArraySolution dnis = new DisappearedNumsInArraySolution();
        int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
        System.out.println(dnis.findDisappearedNumbersInArray(nums));
    }
}
