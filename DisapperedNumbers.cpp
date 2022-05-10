// Time Complexity : O(n)
// Space Complexity : O(1)

// Three line explanation of solution in plain english
/* Iterate over array, go to the index obtained by nums[i] - 1 if the resultant index value is positive then make it negative.
 * Negative value at a index indicates that the index value is present in the array. 
 * At the end perform second iteration and collect the array indexes with the positive values, (index + 1)these are the missing numbers in array.
 */

class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        if (nums.size() == 0)
            return {};
        
        int index;
        vector<int> result;
        
        for (int ele : nums)
        {
            index = abs(ele) - 1;
            if (nums[index] > 0)
            {
                nums[index] = -1 * nums[index]; 
            }
        }
        
        for (index = 0; index < nums.size(); index++)
        {
            if (nums[index] > 0)
                result.push_back(index + 1);   
        }
        return result;
    }
};