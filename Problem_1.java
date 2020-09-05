import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(n) , n = length of array nums
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class Problem_1 {
	
	public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int val = Math.abs(nums[i]) - 1 ;
            if( nums[val] > 0){
                nums[val] = -nums[val];
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                result.add(i+1);
            }
        }
        return result;
    }

}
