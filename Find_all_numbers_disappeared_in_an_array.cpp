/*
Time Complexity: O(n)
Space Complexity: O(1)
Did this code successfully run on Leetcode :yes
Any problem you faced while coding this : no
*/
class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        vector<int> ans;
        int i = 0;
        for(int i = 0; i<nums.size(); i++){
            int index = abs(nums[i])-1;
            if(nums[index]>0){
                nums[index] *= (-1);
            } 
        }
        for(int i = 0; i < nums.size(); i++){
            if(nums[i]>0){
                ans.push_back(i+1);
            }
        }
        return ans;
    }
};