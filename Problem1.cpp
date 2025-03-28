// Time Complexity : O(N) #of elements
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 


// Your code here along with comments explaining your approach:
// 1. Convert element in index of current value to negative if positive. 
// 2. In second traversal [0,n] check if element negative if not add to answer.


class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        int n=nums.size();
        for(int i=0;i<n;i++){
            int t=nums[i]-1;
            if(nums[i]<0){
                t=(-1-nums[i]);
            }
            if(nums[t]>=0){
            nums[t]=(0-nums[t]);}
            cout<<nums[t]<<' ';
        }
        for(int i=0;i<n;i++){
            //cout<<nums[i]<<' ';
        }
        vector<int> ans;
        for(int i=1;i<=n;i++){
            if(nums[i-1]<0){
                continue;
            }
            ans.push_back(i);
        }
        return ans;
    }
};