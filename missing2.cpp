//TC: O(n) where n is number of elements
//SC: O(1)


class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        //can iterate through numbers and set the indexes at the number considered.
        
        vector<int> result;
        
        for(int i=0; i<nums.size(); i++){
            int ind = abs(nums[i])-1;
            if(nums[ind] > 0) {
                nums[ind] = nums[ind]*(-1);
            }
        }
        
        for(int i=0; i<nums.size(); i++){
            if(nums[i] > 0)
                result.push_back(i+1);
        }
        
        return result;
        
    }
};