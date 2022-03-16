public class NumberDissappeared {
  /**
   * Leetcode: (https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)
   * 
   * Given an array of size n with number between [1,n]. Find the missing number.
   * 
   * Can you do it without any extra space?
   * 
   * Time Complexity: O(n)
   * Space complexity: O(1)
   */

  public List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> result = new ArrayList<>();
    
    for(int i = 0; i < nums.length; i++){
        int idx = Math.abs(nums[i]) -1;
        
        if(nums[idx] > 0){
            nums[idx] *= -1;
        }
        
    }
    
    for(int i = 0; i < nums.length; i++){
        if(nums[i] > 0){
            result.add(i+1);
        } else {
            nums[i] *= -1;
        }
    }
    
    return result;       
  }
}
