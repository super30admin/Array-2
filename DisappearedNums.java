import java.util.*;

public class DisappearedNums {

  public static List<Integer> findNumbers(int[] nums) {
    int i = 0;
    while (i < nums.length) {
      if (nums[i] != nums[nums[i] - 1])
        swap(nums, i, nums[i] - 1);
      else
        i++;
    }

    List<Integer> missingNumbers = new ArrayList<>();
    for (i = 0; i < nums.length; i++)
      if (nums[i] != i + 1)
        missingNumbers.add(i + 1);

    return missingNumbers;
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {
    List<Integer> missing = DisappearedNums.findNumbers(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 });
    Object[] res2Array1 = missing.toArray();
    System.out.println(Arrays.toString(res2Array1));

    missing = DisappearedNums.findNumbers(new int[] { 1, 1 });
    Object[] res2Array2 = missing.toArray();
    System.out.println(Arrays.toString(res2Array2));
  }
}