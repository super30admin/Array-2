import java.util.ArrayList;
import java.util.List;

public class FindDisappearingNum {

    public static void main(String[] args) {

        int[] arr = { 4, 3, 2, 7, 8, 2, 3, 1 };
        FindDisappearingNum obj = new FindDisappearingNum();

        List<Integer> obj1 = obj.findNumber(arr);
        System.out.println(" missing num are =" + obj1);

    }

    public List<Integer> findNumber(int[] nums) {
        List<Integer> result = new ArrayList<>();

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