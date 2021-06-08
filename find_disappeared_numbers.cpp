// Time Complexity : O(n)
// Space Complexity :  O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this - Couldn't find the O(1) space solution

class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        
        vector<int> num_arr(nums.size(), 0);
        vector<int> ret_vect;
        
        int i;
        int len = nums.size();

        // Increment counter for numbers present  
        for(i = 0; i < len; i++)
        {
            num_arr[nums[i] - 1]++;
        }
        
        // Find numbers which have 0 counter value
        for(i = 0; i < len; i++)
        {
            if(num_arr[i] == 0)
            {
                ret_vect.push_back(i+1);
            }
        }
        
        return ret_vect;
    }
};