// Time complexity O(n)
// Space complexity O(1)

class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        vector<int> result;
        for (int  i=0; i < nums.size(); i++) {
            int num = abs(nums[i]);
            if (nums[num-1] > 0) {
                nums[num-1] = -nums[num-1];
            }
        }
        for (int  i=0; i < nums.size(); i++) {
            if (nums[i] >= 0)
            {
                result.push_back(i+1);
            }
        }
        return result;
    }
};