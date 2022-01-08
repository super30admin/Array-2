/*
Time complexity: 
O(2n) as we are traversing the given array twice
*/

/*
Space Complexity:
O(1) as we are not creating any space
*/

/*
Approach:
Inorder to find the disappeared numbers in the array, we are taking advantage 
of the given condition that the array has elements from 1 to n. So we have to 
look for the missing numbers in that range. If we are having duplicate elements
in the given array, they are at one of the missing elements. Keeping all these
things in our mind we start traversing the array from the start and mark the 
element as negative which is at the index equivalent to the absolute value of the current
index - 1. Following this pattern, we observe that the few numbers remain positive
and all the other numbers become negative as we reach the end of the array. These are
the numbers which are taking the place of the missing numbers. And we get these numbers
by incrementing the index of these numbers.
*/

// The code ran perfectly on leetcode





class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        
        for(int i = 0; i < nums.size(); i++){
            int x = abs(nums[i]);
            if(nums[x-1] < 0) continue;
            else nums[x-1] = nums[x-1] * -1;
        }
        vector<int> result;
        
        for(int i = 0; i<nums.size(); i++){
            if(nums[i]>0) result.push_back(i+1);
        }
        
        return result;
            
    
    }
};