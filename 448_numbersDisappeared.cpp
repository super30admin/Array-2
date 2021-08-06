// Time Complexity : O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        if(nums.empty() || nums.size() == 0){
            vector<int> x;
            return x;
        }
        vector<int> arr;
        for(int i=0; i<nums.size(); i++){
            int index = abs(nums[i]) - 1;
            if(nums[index] > 0)
                nums[index] = nums[index] * -1;
        }
        for(int i=0; i<nums.size(); i++){
            if(nums[i]>0)
                arr.push_back(i+1);
            else
                nums[i] = nums[i] * -1; // not compulsory to do.
        }
        return arr;
    }
};
