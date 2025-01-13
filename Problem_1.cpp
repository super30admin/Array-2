// Author: Subhed Chavan
// Batch: December 24
// Problem Statement: 448: Find all numbers disappeared in an array
// Approach: Array and Index
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution
{
public:
    vector<int> findDisappearedNumbers(vector<int> &nums)
    {
        vector<int> result;

        // Base Case
        if (nums.size() == 0)
        {
            return result;
        }

        int n = nums.size();

        // Set the value for visited index as -1
        for (int i = 0; i < n; i++)
        {
            int index = abs(nums[i]) - 1;
            if (nums[index] > 0)
            {
                nums[index] = nums[index] * -1;
            }
        }

        // Based on the index find the missing element as the missing element is going to be index + 1
        for (int i = 0; i < n; i++)
        {
            if (nums[i] > 0)
            {
                result.push_back(i + 1);
            }
            else
            {
                nums[i] = nums[i] * -1;
            }
        }

        return result;
    }
};