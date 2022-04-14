// Time Complexity : O(N) 2 pass
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicates {
    public List<Integer> findDuplicates(int[] nums) {

        if(nums.length == 0 || nums == null){
            return new ArrayList<>();
        }

        // Similar sum whenever a number is already negative then that number is repeating

        List<Integer> answer = new ArrayList<>();


        for(int i = 0; i < nums.length; i++){

            int newIndex = Math.abs(nums[i]) - 1;
            if(nums[newIndex] < 0){
                answer.add(Math.abs(nums[i]));
            }else{
                nums[newIndex] = 0 - nums[newIndex];
            }
        }



        return answer;
    }
}
