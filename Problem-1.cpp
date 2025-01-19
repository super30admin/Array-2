// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution
{
public:
    vector<int> findDisappearedNumbers(vector<int> &nums)
    {
        if (nums.empty())
        {
            return {};
        }

        int n = nums.size();
        vector<int> res;
        // set the value for visited index as -1
        for (int i = 0; i < n; i++)
        {
            int t = abs(nums[i]) - 1;
            if (nums[t] > 0)
            {
                nums[t] *= -1;
            }
        }

        // based on the unmarked value with +ve value
        // identify the missing element
        for (int i = 0; i < n; i++)
        {
            if (nums[i] > 0)
            {
                res.push_back(i + 1);
            }
            else
            {
                nums[i] = nums[i] * (-1); // if the constraints expects not to mutate the input vector
            }
        }

        return res;
    }
};