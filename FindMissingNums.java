// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
      List<Integer> result = new ArrayList<>();
      // null case
      if(nums == null || nums.length == 0) {
        return result;
      }
      
      for(int i=0; i< nums.length; i++) {
        //get the index using current value -1;
        int newIndex = Math.abs(nums[i])-1;
        if(nums[newIndex] > 0) {
          // make the number negetive at new index
          nums[newIndex] *= -1;
        }

      }
    
      //record the no if its positive else reverse it to original no
      for(int i=0; i<nums.length; i++) {
        if(nums[i] > 0) {
          result.add(i+1);
        } else {
          nums[i] *= -1;
        }
      }
        return result;
    }
}