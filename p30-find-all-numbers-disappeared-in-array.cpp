// Time complexity is O(n) - n - length of the array
// Space complexity is O(1) - res vector is returned. So, it won't be considered.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach:
/*
    In the First for loop:
    1. Consider only absolute value at each index 'i'.
    2. Go to the index equal to the 'absolute value - 1' and negate it's value if it is positive.
    
    In the Second for loop,
    1. The indices at which the values(nums[i]) are still positive indicate the missing numbers from 1 to n
    2. The 'index+1' will give the missing numbers from 1 to n
    3. The else block represents the values(nums[i]) which are negative.
       So, to keep the given array same, we negate them again.
 */
class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        vector<int> res;
        
        for(int i = 0; i < nums.size(); i++) {
            int temp = abs(nums[i]);
            if(nums[temp-1] > 0)
                nums[temp-1] *= -1;
        }
        
        for(int i = 0; i < nums.size(); i++){
            if(nums[i] > 0)
                res.push_back(i+1);
            else
                nums[i] *= -1;
        }
        return res;
    }
};
