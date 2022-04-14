// Time Complexity                              :  O(N) where N is the size of the vector
// Space Complexity                             :  O(1)
// Did this code successfully run on Leetcode   :  Yes
// Any problem you faced while coding this      :  No

#include <bits/stdc++.h> 
using namespace std;  


class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        int n = nums.size();
        if(n == 0) return vector<int>();
        
        // mutate the array in place
        for(int i=0;i<n;i++) {
            // idx is calculated from the value at the current index i which is also an index somewhere in the array
            int idx = abs(nums[i]) - 1;
            // if the value at the index idx was positive, convert it to negative. 
            // if the value at the index idx was negative, keep it as it is - this indicates we have already visited it
            nums[idx] = nums[idx] > 0 ? nums[idx]*(-1) : nums[idx];
        }
        
        vector<int> ans;
        // the index of every positive value in the array will contribute to the answer.
        for(int i=0;i<n;i++) {
            if(nums[i]>0) ans.push_back(i+1);
        }
        
        return ans;
    }
};