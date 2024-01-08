// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
#include <vector>
#include <iostream>
using namespace std;
class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums){

        vector<int> result;

        for(int i = 0;i<nums.size();i++)
        {
            if(nums[abs(nums[i])-1]>=1)
            {
                nums[abs(nums[i])-1]*=-1;
            }
        }
        for(int i = 0;i<nums.size();i++)
        {
            if(nums[i]>0)
            {
                result.push_back(i+1);
            }
        }
        return result;
        
    }
};