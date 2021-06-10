// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Approach is negating those elements present in the array/vector and in the second pass collecting those indexes which has positive value abd reverting back the negatve elements 

class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) 
    {
        vector<int> result;
        for(int i=0;i<nums.size();i++)
        {
            int numi=abs(nums[i]);
            if(nums[numi-1]>0)
            {
               nums[numi-1]*=-1;
            }
            
        }
        for(int i=0;i<nums.size();i++)
        {
            if(nums[i]<0)
            {
                nums[i]*=-1;
            }
            else
            {
                result.push_back(i+1);
            }
        }
        return result;
    }
};
