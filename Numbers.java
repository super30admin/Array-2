// Overall Time Complexity : O(n) . The n is number of items in the array
// Overall Space Complexity : O(1) . The space complexity is O(1) since there is no auxillary space.
// Any problem you faced while coding this : No issues faced during implementation
// Did this code successfully run on Leetcode :Yes


//For each number n in the array, compute the index n - 1 and negate the value at that index to indicate the presence of n.
// After marking, traverse the array; indices with positive values correspond to missing numbers.
// Collect and return the numbers corresponding to these indices.
import java.util.*;
class Numbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
       List<Integer> res = new ArrayList<>();

       for(int i =0; i<nums.length;i++){
          
          int idx = Math.abs(nums[i])-1;
          if(nums[idx]>0) {
            nums[idx] *= -1;
        }}
        for(int k =0; k<nums.length;k++){
            if(nums[k]>0){
                res.add(k+1);
            }

        }
        return res;
       }
    
}