// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach - we are looping through the enture array
//and the position of the current value and setting its position -1 to the negative value.
// in the end, we will loop through the array and then add all numbers which are still positive


import java.util.*;
/**
 *  MissingNumber : MissingNumber
 *
 * @author : Kavya Mandaliya
 * @version : 1.0 (Nov 07, 2024)
 * @since : 1.0 (Nov 07, 2024)
 *
 */
 public class MissingNumber {
 public List<Integer> findDisappearedNumbers(int[] nums) {
  List<Integer> list = new ArrayList<>();
  for(int i = 0; i < nums.length; i++){
   int tmp = Math.abs(nums[i]);
   if(tmp >= 1 && nums[tmp-1] > 0){
    nums[tmp-1] = -nums[tmp-1];
   }
  }
  for(int i =0 ; i < nums.length; i++){
   if(nums[i] > 0){
    list.add(i+1);
   }
  }
  return list;
 }
}
