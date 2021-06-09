// Time Complexity : O(n)
// Space Complexity : O(1) no extra space used result array isn't counted
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// All numbers disappeared in an array

#include<iostream>
#include<vector>

using namespace std;

class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        
        vector<int> res;
        int temp;
        
        // 1st loop for marking present numbers to -1
        for(int i = 0; i < nums.size(); i++){
            temp = nums[i];
            temp = (temp > 0) ? temp : (-1 * temp);
            if(nums[temp-1] > 0)
                nums[temp-1] = -1 * nums[temp-1];
        }
        
        // 2nd loop for pushing the missing elements into result
        for(int i = 0; i < nums.size(); i++){
            if(nums[i] > 0)
                res.push_back(i+1);
            else
                nums[i] = nums[i] * -1; // keep original state
        }
        
        return res;
    }
};