// Your code here along with comments explaining your approach
import java.util.*;

class MissingItemsInArray {

public static void main(String[] args){
  int[] nums = {4,3,2,7,8,2,3,1};
  List<Integer> output = findDisappearedNumbersOptimal  (nums);
  System.out.printf("[");
  for(int i : output){
    System.out.printf("%d, ",i);
  }
  System.out.printf("]\n");
}

// With EXTRA SPACE
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO
public static List<Integer> findDisappearedNumbers(int[] nums) {
   HashSet<Integer> hSet = new HashSet<>();
   for(int i = 0 ; i< nums.length; i++){
       hSet.add(nums[i]);
   }

   List<Integer> output = new ArrayList<Integer>();
   for(int i = 1 ; i <= nums.length; i++){
       if(!hSet.contains(i)){
           output.add(i);
       }
   }
   return output;
}


// Without EXTRA SPACE
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO
public static List<Integer> findDisappearedNumbersOptimal(int[] nums) {

          for (int i = 0; i < nums.length; i++) {
              int absIndex = Math.abs(nums[i]) - 1;
              if (nums[absIndex] > 0) {
                  nums[absIndex] *= -1;
              }
          }

          List<Integer> output = new ArrayList<Integer>();

          for (int i = 1; i <= nums.length; i++) {
              if (nums[i - 1] > 0) {
                  output.add(i);
              }
          }

          return output;
    }


}
