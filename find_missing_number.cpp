//Time Complexity - O(n)
//Space Complexity - O(1)
//Successfully ran on leetcode
//Use this pattern of making the corresponding numbers negative to mutate the initial state of the array
//The algorithm is as follows -
/* 1. We will go through the array and make the corresponding index of that value negative. For example, nums[0]=4 implies that we go to
      index 4-1=3, and make the element at nums[3] negative. This tells us that number 4 is present.
   2. Once we do this for the entore array, we can just push into the result array the indices of those elements in nums array, which are
      still positive. That will give us those numbers that are missing. */

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
