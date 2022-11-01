/ Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        int n = nums.size();
        //range [1,n]
        vector<int> ret;
        
        for(int num : nums) {
            if (nums[abs(num)-1] > 0) nums[abs(num)-1] *= -1; //make it negative
        }
        
        for (int i=1; i <= nums.size(); i++) {
            if(nums[i-1] > 0) ret.push_back(i);
        }
        
        return ret;
    }
};
