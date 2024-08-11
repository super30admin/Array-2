// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : N/A


// Approach: 
// We mark the index corresponding to numer we are parsing as visited 
// (make it negative since we know for sure all numbers in an array need to be positive)
// then we traverse through the og array, at whichever index we have positive number, 
// we can confidently say that the number corresponding to that index is missing

class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {

        std::vector<int> result;

        for(int i = 0 ; i < nums.size(); i++)
        {
            int num = abs(nums[i]);

            if(nums[num - 1] > 0)
            {
                nums[num - 1] *= -1;
            }
        }

        for(int i =0 ; i < nums.size(); i++)
        {
            if(nums[i] > 0)
            {
                result.push_back(i+1);
            }
        }
        return result;
        
    }
};