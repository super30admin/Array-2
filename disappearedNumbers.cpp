// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
/*Numbers are from 1 to n so numbers are jumbled from respective indexes and can be found using subtracting 1
as indexing start from 0*/
class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        //Without sorting, we will find indexes for respective elements (for i, element must be i+1)
        // Taking care of repetition
        vector<int> ans;
        for(int i=0; i<nums.size(); i++){
            int idx = abs(nums[i])-1;  
            if(nums[idx]>0){
                nums[idx] = (-1)*nums[idx];
            }
        }
        for(int i=0; i<nums.size(); i++){
            if(nums[i] >0){
                int j =i+1;
                ans.push_back(j);
            }
            else{
                nums[i] = nums[i] * (-1); //if you want original array back as it is modified.
            }
        }
        return ans;
    }
};