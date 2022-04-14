// Time Complexity : O(N) 2 pass
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : On first try i did not take absolute value of nums[i] so ArrayIndexOutofBounds i got.


// Your code here along with comments explaining your approach
import java.util.ArrayList;
import java.util.List;

public class FindAllDisappearedNumbers {

    public List<Integer> findDisappearedNumbers(int[] nums) {


        if(nums.length == 0 || nums == null){
            return new ArrayList<>();
        }

        List<Integer> answer = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){ // Marking nums[number encountered - 1] negative
            int newIndex = Math.abs(nums[i]) - 1;
            if(nums[newIndex] > 0){
                nums[newIndex] = 0 - nums[newIndex];
            }
        }

        // Now the index where positive number exist + 1 are the missing number

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                answer.add(i+1);
            }
        }

        System.out.println(answer);
        return answer;
    }
}
