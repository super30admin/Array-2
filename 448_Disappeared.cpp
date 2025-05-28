// Time Complexity: O(n) — We scan the array twice, both linear passes.
// Space Complexity: O(1) — We use no extra space except the output list.

// Approach in 3 lines:

// For each number, mark the element at its corresponding index negative to indicate that number is present.

// After marking, the indices that remain positive correspond to missing numbers.

// Collect these indices +1 as the answer.

class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        vector<int> ans;
        for(int i=0;i<nums.size();++i){
            if(nums[abs(nums[i])-1] > 0)
                nums[abs(nums[i])-1] = -1 * nums[abs(nums[i])-1];
        }
        for(int i=0;i<nums.size();++i)
            if(nums[i] < 0)
                nums[i] *= -1;
            else
                ans.emplace_back(i+1);
        return ans;
    }
};
