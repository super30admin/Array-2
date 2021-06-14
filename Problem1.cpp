// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums)
    {
        vector<int> ans;
        set<int> set1;
        for(int i:nums){
            set1.insert(i);
        }
        
        for(int i=1;i<=nums.size();i++){
            if(set1.find(i)==set1.end()){
                ans.push_back(i);
            }
        }
        return ans;
    }
};