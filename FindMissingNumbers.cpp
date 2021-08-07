// Time Complexity : O(N) where N is the number of elements in the array
// Space Complexity : O(1) as I am not using any extra space and just building the array which needs to be returned
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope
// Problem Link: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
// Submission Link: https://leetcode.com/submissions/detail/533982431/

class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        int i = 0;
        int temp;
        
        while(i < nums.size()){
            if(nums[i] != i + 1){
                while(nums[i] != i+1 && nums[nums[i] - 1] != nums[i]){
                    temp = nums[i];
                    nums[i] = nums[temp - 1];
                    nums[temp - 1] = temp;
                }
            }
            i++;
        }
        vector<int> ans;
        
        for(int i = 0; i < nums.size(); i++)
            if(nums[i] != i + 1)
                ans.push_back(i + 1);
        
        return ans;
    }
};