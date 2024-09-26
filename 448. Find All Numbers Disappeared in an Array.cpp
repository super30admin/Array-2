//Time Complexity = O(N)
//Space Complexity = O(1)
//Where N is the Number of elements int the vector nums.
//Here the space complexity is O(1) because we are taking the extra space (vector<int> ans) and returning the same through the function.

class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        int i;
        vector<int> ans;
        for(i=0;i<nums.size();i++)
        {
            if(nums[abs(nums[i])-1]>0)
                nums[abs(nums[i])-1] = -1*nums[abs(nums[i])-1];
        }
        for(i=0;i<nums.size();i++)
            if(nums[i]>0)
                ans.push_back(i+1);
        for(i=0;i<nums.size();i++)
            nums[i]=abs(nums[i]);
        return ans;
    }
};
