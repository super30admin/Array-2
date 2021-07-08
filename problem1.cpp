// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Algorithm was not at all intuitive but works really well


// Your code here along with comments explaining your approach

/*
--> Since the max value inside the array is at the most the size of the array, we use this for our benefit
--> For each element in the array, we update the index represented by the element to negative value.
        For example, for value 8, we update the value at index 7 as -value.
--> Thus only those values are left +ve whose indices are not present in the array. Append all those in the solution array

*/


#include <iostream>
#include <vector>
#include<stdlib.h>

using namespace std;

class Solution{
    public:
        vector<int> findDisappearedNumbers(vector<int>& nums) 
        {   
            if(nums.size() == 0) return vector<int>();

            vector<int>missingValues;

            for(int i = 0; i<nums.size(); i++)
            {
                int index = abs(nums[i]) - 1;

                if(nums[index] > 0) nums[index] = -nums[index];

            }

            for(int i = 0; i<nums.size(); i++)
                if(nums[i] > 0) missingValues.push_back(i+1);
            

            return missingValues;
        }
};;