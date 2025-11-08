/**** Method 1 ****/
//Time Complexity: O(n^2)
//Space Complexity: O(1)

//Successfully submitted in LeetCode

//Take two loops one from 1 to n and another to traverse the arr and check if ele from first loop is present or not. If not add to missing list. At the end return missing list.

/**** Method 2 ****/
//Time Complexity: O(n)
//Space Complexity: O(n)

//Successfully submitted in LeetCode

//Traverse the arr and store all it's values in set, later start another loop from 1 to n and check if set contains it or not. If not add to missing list. At the end return missing list.

/**** Method 3 ****/
//Time Complexity: O(n)
//Space Complexity: O(1)

//Successfully submitted in LeetCode

//ONLY IF WE CAN MODIFY THE GIVEN ARR. As all the elements present should generally be less than n, we can traverse the arr and make the index of the value as -ve, so in this way all elements in arr will have there index marked -ve. So at end we can traverse the array and add the missing items(which values are not -ve) to list.

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ARR2_448_Find_All_Numbers_Disappeared_in_an_Array {

  /**** Method 1 ****/
  public List<Integer> findDisappearedNumbers1(int[] nums) {
    List<Integer> ans = new ArrayList<>();

    for (int i = 1; i <= nums.length; i++) {
      boolean flag = false;
      int idx = 0;
      while (idx < nums.length) {
        if (nums[idx] == i) {
          flag = true;
          break;
        }
      }
      if (!flag) {
        ans.add(i);
      }
    }
    return ans;
  }

  /**** Method 2 ****/
  public List<Integer> findDisappearedNumbers2(int[] nums) {
    List<Integer> ans = new ArrayList<>();
    HashSet<Integer> set = new HashSet<>();

    for (int i : nums) {
      set.add(i);
    }

    for (int i = 1; i <= nums.length; i++) {
      if (!set.contains(i)) {
        ans.add(i);
      }
    }

    return ans;
  }

  /**** Method 3 ****/
  public List<Integer> findDisappearedNumbers3(int[] nums) {
    List<Integer> ans = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {
      if (nums[Math.abs(nums[i]) - 1] > 0) {
        nums[Math.abs(nums[i]) - 1] *= -1;
      }
    }

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        ans.add(i + 1);
      }
    }

    return ans;
  }
}
