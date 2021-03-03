/*Time Complexity :O(log(n))
Space Complexity :O(1)
*/


class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        vector<int>result;
        for(int i = 0; i < nums.size();i++){
            
            int ind = abs(nums[i])-1;
            if(nums[ind]>0)nums[ind] = -nums[ind];
            
        }
        for(int i = 0; i < nums.size();i++){
            if(nums[i]>0)result.push_back(i+1);
            
        }
        return result;
        
    }
};