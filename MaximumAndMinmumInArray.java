public class MaximumAndMinmumInArray {
  /**
   * 
   * O(n) solution is trivial
   * 
   * Reduce the number of comparisions you are making.
   * 
   * 
   * Time Complexity: O(n)
   * Space Complexity: O(1)
   * 
   * Were you able to solve this problem? Yes
   * Did you have any issues solving this? No
   */

   int[] findMaximumAndMinimum(int[] nums){
     int min = Integer.MAX_VALUE;
     int max = Integer.MIN_VALUE;

     int i = 0, j = 1;

     while(i < nums.length && j < nums.length){
       if(nums[i] > nums[j]) {
         max = Math.max(nums[i], max);
         min = Math.min(nums[j], min);
       } else {
        max = Math.max(nums[j], max);
        min = Math.min(nums[i], min);
       }

       i += 2;
       j += 2;
     }

     if(nums.length % 2 != 0){
       max = Math.max(max, nums[nums.length-1]);
       min = Math.min(min, nums[nums.length-1]);
     }

     return new int[]{max, min};
   }
}
