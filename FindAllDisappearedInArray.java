// TC : O(nlogn)
// SC : O(1)
// Approach : add all numbers from 1 to n in set, sort original array, remove element from set that is present in array
// return all the elements left in set that means they are not present in original input array

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FindAllDisappearedInArray {

  public List<Integer> findDisappearedNumbers(int[] nums) {

    HashSet<Integer> set = new HashSet<>();
    int n = nums.length;

    for (int i = 1; i <= n; i++) {
      set.add(i);
    }

    Arrays.sort(nums);

    for (int num : nums) {
      set.remove(num);
    }
    return new ArrayList<>(set);
  }

  public static void main(String[] args) {
    FindAllDisappearedInArray f = new FindAllDisappearedInArray();
    int[] nums = new int[] { 4, 3, 2, 7, 8, 2, 3, 1 };

    System.out.println(f.findDisappearedNumbers(nums));
  }
}