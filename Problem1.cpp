// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        //go to each nums[i-1] index and make it -nums[i-1] if its not negative
        vector<int> res;
        for(int i=0; i<nums.size(); i++){
            int n = abs(nums[i]);
            if(nums[n-1]>0){
                nums[n-1]=-1*nums[n-1];
            }
        }
        
        for(int i=0; i<nums.size();i++){
            if(nums[i]>0)
                res.push_back(i+1);
        }
        
        
        return res;
    }
};
