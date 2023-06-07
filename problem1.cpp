# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        
        int n=nums.size();
        vector<int> ans;
        for(int i=0; i<n; i++)
        {
            int index = abs(nums[i])-1;
            if(nums[index]>0) 
                nums[index] = -nums[index];
        }
        for(int i=0; i<n; i++)
        {
            if(nums[i]>0) 
                ans.push_back(i+1);
        }
        return ans;

    }
};