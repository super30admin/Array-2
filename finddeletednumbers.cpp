//Time complexity: O(n)
//Space complexity : O(1)
//Leetcode : Yes

// //Approach :
//             Get the indices of all present elements by subtracting 1 from each element and then multiplying the value at that index by -1
//             In the second pass, just take note of all the positive numbers and its index. Return index + 1 of each positive number

class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        if(nums.size() == 0)
            return {};
        
        vector<int> result;
        
        for(int i = 0 ; i < nums.size(); i++)
        {
            int temp = abs(nums[i]) - 1;
            
            if(nums[temp] > 0)
            {
                nums[temp] *= -1;
            }
        }
        
        for(int i = 0; i < nums.size(); i++)
        {
            if(nums[i] > 0)
            {
                result.push_back(i + 1);
            }
        }
        
        return result;
    }
};