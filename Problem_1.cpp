/*
 * Time Complexity : O(n)
 * Space Complexity : O(1)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
*/

#include <vector>

class Solution {
public:
    std::vector<int> findDisappearedNumbers(std::vector<int>& nums) {
        int n = nums.size();
        if (n == 0) return {};

        std::vector<int> missing_nums;
        for (int i = 0; i < n; i++) {
            int index = abs(nums[i]) - 1;
            if (nums[index] > 0)
                nums[index] *= -1;
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0)
                missing_nums.push_back(i + 1);
        }

        return missing_nums;
    }
};
