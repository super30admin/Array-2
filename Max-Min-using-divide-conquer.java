// Time Complexity :O(3n/2 -2) comparisions which is less than 2n -2
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// similar to divide and conquer approach in merge sort,
// instead of comparing and adding to sorted list i am comparing min and max of 2 halves

class Solution {

  public static void main(String[] args) {
    int[] nums = {2, 4, 6, 8,1, 3, 4,5, 10};
    int[] res = getMinMax(nums, 0, nums.length-1);
    System.out.println(res[0] + "   " + res[1]);
  }
  public static int[] getMinMax(int[] nums, int i, int j) {

    //System.out.println("i :" + i +" j: "+ j);
      if (j >= i){

        if (j-i == 0) { //if only one element left
          System.out.println( " min max " + nums[i] + " " +  nums[j]);
          return new int[] {nums[i], nums[i]};
        }

        if(j-i ==1) { // if only 2 elements to compare
          if (nums[j] > nums[i]) {
            //System.out.println( " min max " + nums[i] + " " +  nums[j]);
            return new int[] {nums[i], nums[j]};
          } else {
            //System.out.println( " min max " + nums[j] + " " +  nums[i]);
            return new int[] {nums[j], nums[i]};
          }
        }

        int mid = (i + j)/2;
        int[] firstHalf = getMinMax(nums, i, mid);
        int[] secondHalf = getMinMax(nums, mid+1, j);

        int min = Math.min(firstHalf[0], secondHalf[0]);
        int max = Math.max(firstHalf[1], secondHalf[1]);
        //System.out.println( " min max " + min + " " + max);
        return new int[]{min, max};
      }
      return new int[]{0,0};
  }
}
