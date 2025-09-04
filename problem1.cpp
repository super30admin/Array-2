// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// We use a negative tagging approach, where we go to an index and check its abs value, go to the index pointed by that element (element - 1) and negate the element at that index
// Then, go over all the elements in the modified array, the indices which are positive correspond to the missing numbers (missing = index + 1)

class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        int n = nums.size();
        for(int i=0; i<n; i++) {
            int idx = abs(nums[i]) - 1;
            if(nums[idx] > 0) {
                nums[idx] = nums[idx] * -1;
            }
        }
        vector<int> result;
        for(int i=0; i<n; i++) {
            if(nums[i] > 0) {
                result.push_back(i + 1);
            }
        }
        return result;
    }
};