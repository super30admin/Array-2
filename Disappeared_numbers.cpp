// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        vector<int> result;
        if(nums.size()==0){
            return {};
        }
        
        for(int i=0;i<nums.size();i++){
            int index = abs(nums[i])-1;
            if(nums[index]>0){
                nums[index]*=-1;
            }
        }
        for(int i = 0; i<nums.size();i++){
            if(nums[i]>0){
                result.push_back(i+1);
            }
        }
        return result;
    }
};
