//Time Complexity O(numberOfCoins*amount)
//Space Complexity O(numberOfCoins*amount)

// Problem successfully compiled on leetcode
// No Problems faced while figuring out the logic

#include<vector>
#include<iostream>
using namespace std;

class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        vector<int> result;
        
        int indexToMakeNegative;
        for(int i=0;i<nums.size();i++)
        {
            indexToMakeNegative=abs(nums[i])-1;
            if(nums[indexToMakeNegative]>0)
            {
                int z=nums[indexToMakeNegative];
                nums[indexToMakeNegative]=z*(-1);
            }
        }
        for(int i=0;i<nums.size();i++)
        {
            if(nums[i]>0)
            {
                result.push_back(i+1);
            }
        }
        
        return result;
    }
};