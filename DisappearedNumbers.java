import java.util.ArrayList;
import java.util.List;

//Time Complexity : O(n)
//Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class DisappearedNumbers {

  public List<Integer> findDisappearedNumber(int[] nums) {
  List<Integer> result = new ArrayList<>();

  //First traversal
  for(int i =0 ; i < nums.length; i ++) {
      int index = Math.abs(nums[i]) - 1;
      if(nums[index] > 0 ) {
        nums[index] *= -1;
      }
  }

  //second traversal
    for(int i=0; i < nums.length; i++) {
      if (nums[i] > 0) {
        result.add(i+1);
      } else {
        nums[i] *= -1;
      }
    }
  return  result;
  }
}
