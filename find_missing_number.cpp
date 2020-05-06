//Time Complexity - O(n)
//Space Complexity - O(1)
//Successfully ran on leetcode
//Use this pattern of making the corresponding numbers negative to mutate the initial state of the array

class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        if(nums.empty())
            return {};
        int n=nums.size();
        vector<int>A;
        for(int i=0;i<n;i++)
        {
            int index=abs(nums[i])-1;
            if(nums[index]>0)
                nums[index]=nums[index]* (-1);       
        }
        for(int i=0;i<n;i++)
        {
            if(nums[i]>0)
                A.push_back(i+1);
        }
        return A;
    }
};