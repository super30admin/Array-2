class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        int result[nums.size()+1];
        memset(result, 0 , sizeof(result));
        vector<int> res;
        for(int i =0;i<nums.size();i++){
            result[nums[i]] = 1;
        }
        
        for(int i=1;i<=nums.size();i++){
            cout<<result[i];
            if(result[i]==0){
             
            res.push_back(i);   
            }
        }
        return res;
    }
};
