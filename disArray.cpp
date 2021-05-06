// Time Complexity :O(n) where n in the number elements in the vector
// Space Complexity : O(1)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        vector<int> ans;
        int val;
        for(int i = 0;i<nums.size();i++){
            val = abs(nums[i]);
            if(nums[val-1] < 0)
                continue;
            else
                nums[val-1]*=-1;
        }
        for(int i = 0;i<nums.size();i++){
            if(nums[i] > 0)
                ans.push_back(i+1);
        }
        return ans;
    }
};