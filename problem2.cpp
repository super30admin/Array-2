// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

#include <iostream>
#include <vector>
using namespace std;
 
void findMinAndMax(vector<int> const &nums, int &min, int &max)
{
    max = nums[0], min = nums[0];
 
    for (int i = 1; i < nums.size(); i++)
    {
        if (nums[i] > max) {
            max = nums[i];
        }
         else if (nums[i] < min) {
            min = nums[i];
        }
    }
}
 
int main()
{
    vector<int> nums = { 5, 7, 2, 4, 9, 6 };
 
    int min, max;
 
    findMinAndMax(nums, min, max);
 
    cout << "minimum element =" << min << endl;
    cout << "maximum element = " << max << endl;
 
    return 0;
}
