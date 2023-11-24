//TC: O(n)
//SC: O(1)

class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {

        vector<int> result = {0};
        int n = nums.size() ;

        for(int i = 0; i<n ; i++)
        {
            int number = abs(nums[i]);
            int index = number - 1;

            if(nums[index] > 0)
            {
                nums[index] *= -1;
            }
        }
        for(int i = 0; i < n ; i++)
        {            
            if(nums[i] > 0)
            {
                result.push_back(nums[i+1]);
            }
            else
            {
                nums[i] *= -1;
            }
        }

        return result;
        
    }
};