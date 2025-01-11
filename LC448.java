// TC: O(n)
// SC: O(1)

import java.util.*;

public class LC448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int currEle = nums[i];
            int nextEle = nums[currEle - 1];
            while (currEle != nextEle) {
                nums[i] = nextEle;
                nums[currEle - 1] = currEle;
                currEle = nums[i];
                nextEle = nums[nums[i] - 1];
            }
        }

        for (int i = 0; i < n; i++) {
            if (i != nums[i] - 1)
                ans.add(i + 1);
        }
        return ans;
    }
}