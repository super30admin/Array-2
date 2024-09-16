//Time Complexity - O(n)
//Space Complexity - O(1)
// runs successfully on leetcode


class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        if(nums.empty())
            return {};
        int n=nums.size();
        vector<int>result;
        for(int i=0;i<n;i++)
        {
            int idx=abs(nums[i])-1;
            if(nums[idx]>0)
                nums[idx]=nums[idx]* (-1);       
        }
        for(int i=0;i<n;i++)
        {
            if(nums[i]>0)
                result.push_back(i+1);
        }
        return result;
    }
};