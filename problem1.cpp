//time complexity : o(n)
//space complexity :  o(1)

class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        
        if(nums.size() == 0) return {};
        int n = nums.size();
        
        for(int i =0;i<n;i++) {
            int index = abs(nums[i]) -1;
            
            if(nums[index] > 0) {
                 nums[index] =  nums[index] * -1;
            }
        }
        
        vector<int> v;
         for(int i =0;i<n;i++) { 
            if(nums[i] > 0) {
                v.push_back(i+1);
            }  else {
               nums[i] = nums[i] * -1; 
            }
             
         }
        
        return v;
        
    }
};