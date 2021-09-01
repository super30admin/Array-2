
// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        if(nums.size() == 0 ) return nums;  
        vector<int> result;  // initialize result array
        for(int i = 0; i<nums.size(); i++)
        {
            if(nums[abs(nums[i])-1] >0)   // input element's respective index's element as negative if not negative
            {
                nums[abs(nums[i]) - 1] *= -1;
            }
        }
        for(int i = 0; i<nums.size(); i++)
        {
            if(nums[i] >0){        // check if any element is non negative, then the respective index is missing and is pushed back into result array
                result.push_back(i+1);
            }
        }
        
        return result;  // return the resultant array
    }
};

// int main(){
    
//     return 0;
// }