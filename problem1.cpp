class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        
        
        vector<int> res;
        unordered_map<int,bool> map;
        
        for(int i=0;i<nums.size();i++)
        {
         map[nums[i]]=true;   
        }
        for(int i=1;i<=nums.size();i++)
        {
            if(!map.count(i))
            {
                res.push_back(i);
            }
        }
        return res;
    }
};
