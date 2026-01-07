// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Approach
// Sort and search linearly  - O(nlogn) time, O(1) space
// keep hash set and search linearly for missing value - O(n) time, O(n) space
// Do inplace negative marking  - O(n) time, O(1) space.
// Marking nums[nums[i]] as negative indicates nums[i] is present in the array.
import java.util.ArrayList;
import java.util.List;

class DisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int temp = Math.abs(nums[i]-1);
            // Mark it negative only if it is positive else, in case of duplicates,
            // -(- val) will become positive
            if(nums[temp] > 0){
                nums[temp] *= -1;
            }
        }

        // Value which are still positive do not have a corresponding number in the array.
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                result.add(i+1);
            }
        }

        return result;
    }
}