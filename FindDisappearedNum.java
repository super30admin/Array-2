// Time Complexity : O(n), where n is the length of the input array
// Space Complexity : O(1) (ignoring the output list)
// Did this code successfully run on Leetcode : Yes

//Approach:
// 1. Mark index (num - 1) as negative to indicate presence
// 2. Traverse array to find indices with positive values
// 3. Add (index + 1) to result as missing numbers

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNum {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;

        for(int i = 0; i < n; i++){
            int idx = Math.abs(nums[i]) - 1;

            if(nums[idx] > 0){
                nums[idx] = nums[idx] * -1;
            }
        }

        for(int i = 0; i < n; i++){
            if(nums[i] > 0){
                result.add(i + 1);
            }
        }
        return result;
    }
}
