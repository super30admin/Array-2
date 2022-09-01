// Time Complexity - O(n)
// Space Complexity - O(1)

import java.util.ArrayList;
import java.util.List;

public class FindMissingNumbersArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;

        int n = nums.length;
        for (int i=0; i<n ; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx]>0) {
                nums[idx] *= -1;
            }
        }

        for(int j=0; j<n; j++) {
            if(nums[j]>0) {
                result.add(j+1); // add the missing elements to result list
            }
            else{
                nums[j] *= -1; // revert the input array to its original value
            }
        }
        return result;
    }
}
