class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        vector<int> ans;
        vector<int> ans_2;
        int n = nums.size();
        int count = 0;

   


        for(int i=0 ; i<n ;i++){
            int idx = abs(nums[i]) - 1;
            if(nums[idx]>0){
                nums[idx] = nums[idx]*-1;
            }
        }

        for(int i=0 ; i<n ; i++){
            if(nums[i]>0){
                ans.push_back(i+1);
            }
        }


        return ans;
    }
};
