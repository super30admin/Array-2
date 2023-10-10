class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        int n=nums.size();
        vector<int> result(n,1);
        vector<int> ans;
        for(int i=0;i<n;i++){
           if(result[nums[i]-1]!=-1)
            result[nums[i]-1] *=-1;
        }
        for(int i=0;i<n;i++){
            if(result[i]==1 )
            ans.push_back(i+1);
        }
    return ans;
    }
};
