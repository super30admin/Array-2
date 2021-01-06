import java.util.*;



class FindMinMaxinArr {

  public static void main(String[] args){
      int arr[] = {1000, 11, 445, 1, 330, 3000};
      int[] output = findMinMaxBF(arr);
      System.out.printf("Min : %d\n", output[0]);
      System.out.printf("Max : %d\n", output[1]);
  }

  // Brut force : do linear search keep track of min and max and update at each index if required
  // Time Complexity : O(N)
  // Space Complexity : O(1)
  // # of comparisons : 2N
  // Did this code successfully run on Leetcode : NA
  // Any problem you faced while coding this : NO

  public static int[] findMinMaxBF(int[] nums){
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;

    for(int i = 0; i < nums.length; i++){
      if(nums[i] > max){
        max = nums[i];
      }
      if(nums[i] < min){
        min = nums[i];
      }
    }

    return new int[]{min,max};
  }


}
