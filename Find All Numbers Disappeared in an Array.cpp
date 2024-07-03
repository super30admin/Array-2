// as discussed in class
// time: O(n)
// space: O(1)
class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        vector<int> result;
        int n = nums.size();
        for(int i = 0; i < n; i++) {
            if(nums[abs(nums[i])-1] > 0) {
                nums[abs(nums[i])-1] = nums[abs(nums[i])-1] * (-1);
            }
            // nums[abs(nums[i])-1] = abs(nums[abs(nums[i])-1]) * (-1);
            // cout<<nums[nums[i]-1]<<" ";
        }
        for(int i = 0; i < n; i++) {
            if(nums[i] > 0) {
                result.push_back(i+1);
            } else {
                nums[i] *= -1;
            }
        }
        return result;
    }
};