// Time Complexity : O(n+n)=O(n) first loop to negate numbers that occurred and second loop to find positive numbers as they are not yet appeared
// Space Complexity : O(1) as no new space is used and only existing array is modified
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        vector<int> res;
        // Check and negate the (nums[i]-1)th index to mark
        // the occurance of nums[i] value in the array
        for(int i=0;i<nums.size();i++)
        {
            if(nums[std::abs(nums[i])-1] > 0)
                nums[std::abs(nums[i])-1] = -1 * nums[std::abs(nums[i])-1];
        }

        for(int i=0;i<nums.size();i++)
        {
            if(nums[i] > 0)
                res.push_back(i+1);
        }
        return res;
    }
};