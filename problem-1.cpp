// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
// Time Complexity : O(n) where n is the length of the input array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Iterate through the array and make the element at the num[i-1] negative.
// So all the elements that are present in the array will have a negative value at their indices.
// If there are positive values then they are not present in the array


class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        int n = nums.size();
        vector<int> res;
        for(int i=0; i<n; i++){
            int temp = abs(nums[i]);
            if(nums[temp-1] < 0) continue;
            nums[temp-1] *= -1;
        }
        for(int i=0; i<n; i++){
            if(nums[i] > 0){
                res.push_back(i+1);
            }
        }
        return res;

    }
};