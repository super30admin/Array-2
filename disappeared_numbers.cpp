// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Go to each element, check if the index position of that number(element-1) is in array and is a positive number.
// If the element at the index position is positive then make it negative. Repeat this process for all the elements.
// After this step, check for positive elements and return indices. Those positive elements are the disappearing elements. 
// As an extra step we make all elements as positive to restore input array. 


#include <vector>

class Solution {
public:
    std::vector<int> findDisappearedNumbers(std::vector<int>& nums) {
        std::vector<int> result;
        for(int i = 0; i < nums.size(); i++)
        {
            // recording that the element corresponding the index is found.
            int idx = abs(nums[i]) - 1;
            if(nums[idx] > 0)
            {
                nums[idx] *= -1;
            }
        }

        for(int i = 0; i < nums.size(); i++)
        {
            // Getting the missing elements based on sign 
            if(nums[i] > 0)
            {
                result.push_back(i+1);
            }
            else // reverting the input array back 
            {
                nums[i] *= -1;
            }
        }
        return result;
    }
};