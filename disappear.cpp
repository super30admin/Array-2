// Time Complexity :O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// Go to each element for ex 1,2,3,3 and go to corresponding index if it is not negative make it negative .
// At the end of the traversal in the array elements which are not negative that corresponding index+1 are the missing numbers




class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {

        vector<int>ans;

        for(int i=0;i<nums.size();i++)
        {
        
            int x=abs(nums[i]);
            if(nums[x-1]>0)
              nums[x-1]=-1*nums[x-1];
        }


        for(int i=0;i<nums.size();i++)
        {
            if(nums[i]>0)
            {
                ans.push_back(i+1);
            }
        }
        return ans;

        
    }
};