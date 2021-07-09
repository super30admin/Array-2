import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class findDisappearedNums {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<Integer>();
        }
        
        List<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++){
            //index of value
            int index = Math.abs(nums[i]) - 1;
            
            //negating it to indicate found value
            if(nums[index] > 0){
                nums[index] *= -1;
            }
        }
        
        for(int i = 0; i < nums.length; i++){
            //still positive, missing
            if(nums[i] > 0){
                result.add(i + 1);
            }
            
            //negative, changing back to actual value
            else{
                nums[i] *= -1;
            }
        }
        return result;
    }
}