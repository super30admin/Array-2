
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Negated the value of the index while iterating for the first time and iterated again to find the missing number by looking the
// values greater than 0 and added to result list
import java.util.ArrayList;
import java.util.List;

public class FindAllDisappearedNumsInArr {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        if(nums == null || nums.length == 0){
            return result;
        }

        for(int i =0; i<nums.length; i++){
            int index = Math.abs(nums[i])-1;

            if(nums[index] > 0){
                nums[index] *= -1;
            }
        }

        for(int j =0; j<nums.length; j++){
            if(nums[j] > 0){
                result.add(j+1);
            }else{
                nums[j] *= -1;
            }
        }
        return result;
    }
}
