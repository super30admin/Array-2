// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        for(int i = 0; i < nums.size(); i++) {
            if(nums[abs(nums[i]) - 1] > 0) {
                nums[abs(nums[i]) - 1] = -1 * nums[abs(nums[i]) - 1];
            }
        }

        vector<int> result; 

        for(int i = 0; i < nums.size(); i++) {
            if(nums[i] > 0) {
                result.push_back(i+1);
            }
        }

        return result;     
    }
};