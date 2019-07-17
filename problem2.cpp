// Time Complexity : O(1.5n)
// Space Complexity : O(1) //
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach/


/*
Brute force: -> Keep checking for max and min in the entire array. 2n - 2.

Efficient solution -> Get min and max pairs throughout the array. 
                      Then update the min and max between them. n/2 + n -> 1.5n

 */

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution{
    public:
        void minMax(vector<int> &nums) 
        {
            if(nums.size() == 0) return;

            int minValue, maxValue;
    
            if(nums.size() == 1) 
            {
                minValue = nums[0];
                maxValue = nums[0];

                cout<<"Min Value :"<<minValue<<endl;
                cout<<"Max Value :"<<maxValue<<endl;

                return;
            }

            if(nums[0] > nums[1])
            {
                minValue = nums[1];
                maxValue = nums[0];
            }

            else
            {
                minValue = nums[0];
                maxValue = nums[1];   
            }

            for(int i = 2; i < nums.size()- 2; i = i+2)
            {
                if(nums[i] > nums[i + 1])
                {
                    minValue = min(minValue, nums[i + 1]);
                    maxValue = max(maxValue, nums[i]);
                }

                else
                {   
                    minValue = min(maxValue, nums[i]);
                    maxValue = max(minValue, nums[i + 1]);
                }
            }

            if(nums.size() % 2 == 1) //last element of the array
            {
                minValue = min(minValue, nums[nums.size() - 1]);
                minValue = max(maxValue, nums[nums.size() - 1]);
            }

            cout<<"Min Value :"<<minValue<<endl;
            cout<<"Max Value :"<<maxValue<<endl;
        }
};    

        
