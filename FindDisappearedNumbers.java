// Time Complexity : O(log(n)) (for sorting) + O(n) for traversal ==> O(n)
//adding elements to a List is done is O(1)
// Space Complexity : O(1) as we're not using any auxiliary data structure
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDisappearedNumbers {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length < 1) {
            return null;
        }
        int n = nums.length;
        int peak = -1;

        Arrays.sort(nums);// O(log(n))
        List<Integer> missingElements = new ArrayList<>();

        //if missing from left
        addMissingElements(1, nums[0] - 1, missingElements);

        for (int index = 1; index < n; index++) {
            int diff = nums[index] - nums[index - 1];
            if (diff > 1) {
                peak = index;
                //if missing from the middle
                addMissingElements(nums[peak - 1] + 1, nums[peak] - 1, missingElements);
            }
        }

        //if missing from the right
        addMissingElements(nums[n - 1] + 1, n, missingElements);
        return missingElements;
    }

    private void addMissingElements(int start, int end, List<Integer> missingElements) {
        for (int i = start; i <= end; i++) {
            missingElements.add(i);
        }
    }
}
