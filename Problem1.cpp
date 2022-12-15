// Find All Numbers Disappeared in an Array
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Approach
// If a number is present inside the list, go to its corresponding index & if it's positive, make it negative. The logic to mark it negetive is the tricky part which is the STATE CHANGE Pattern.
// Again traverse the list and we will find some indices whose elements are not negative. So the missing number is (index+1) and store it in result.
// Also, it's a good practice to return the original array, so if an element is negative multiply by -1.

class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        // TC = O(n)
        // SC = O(1)
        // null
        if(nums.size() == 0) return vector<int>();
        vector<int> result;
        for(int i = 0; i < nums.size(); i++) {
            // getting corresponding number, so -1
            int index = abs(nums[i]) - 1;
            // marking visited no (it means exists) if not already visited
            if(nums[index] > 0) nums[index] *= -1;
        }
        for(int i = 0; i < nums.size(); i++) {
            // getting corresponding non-visited no
            if(nums[i] > 0) result.push_back(i + 1);
            // making nums back to original
            else nums[i] *= -1;
        }
        return result;
    }
};