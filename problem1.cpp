// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes

// we traverse through the array and  each time we take nums[i] -1 as index and make the number at that index as negative.
// At last we check for numbers that are positive in the array and these indexes are to be treated as our required numbers -1.
// so add 1 to the number and store those in the array and return.




class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        if(nums.empty() || nums.size()==0){
            return {};
        }
        vector<int>result;
        for(int i=0;i<nums.size();i++)
        {
            int index = abs(nums[i]) - 1;
            if(nums[index] < 0) continue;
            nums[index] = -nums[index];
        }
        for(int i=0;i<nums.size();i++)
        {
            if(nums[i] > 0){
                result.push_back(i+1);
            }
            else{
                nums[i] = -nums[i];
            }
        }
        return result;
    }
};