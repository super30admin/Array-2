import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedinArray {

    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 })); // 5,6
        System.out.println(findDisappearedNumbers(new int[] { 1, 1 })); // 2
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;
        for (int i = 0; i < nums.length; i++) {
            int currentElement = Math.abs(nums[i]) - 1;
            if (nums[currentElement] > 0) {
                nums[currentElement] *= -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                result.add(i + 1);
        }
        return result;
    }

}