class Solution
{
public:
    vector<int> findDisappearedNumbers(vector<int> &nums)
    {
        // using a hash set
        //  declare a hash set

        unordered_set<int> h_set;
        vector<int> result;
        for (int i = 0; i < nums.size(); i++)
        {

            h_set.insert(nums[i]);
        }

        for (int i = 1; i <= nums.size(); i++)
        {

            if (h_set.find(i) == h_set.end())
            {
                result.push_back(i);
            }
        }

        return result;
    }
};