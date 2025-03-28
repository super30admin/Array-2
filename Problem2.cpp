// Time Complexity : O(N) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 


// Your code here along with comments explaining your approach:
// 1. Traverse skipping next element while maintaining min and max variable;
// 2. Compare only with min and minimum between curr and prev.
// 3. Compare only with max and maximum between curr and prev and 
// again compare with last if #of elements are odd.


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