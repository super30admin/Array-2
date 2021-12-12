#include <iostream>
#include <vector>
#include <math.h>

using namespace std;

//Time complexity : O(n)
//Space complexity : O(1)

//Approach : Check all the elements in pairs to minimize the number of comparisons

vector<int> minandmax(vector<int> nums)
{
    int mn = INT_MAX;
    int mx = INT_MIN;

    for(int i = 0 ; i < nums.size() - 1; i++)
    {
        if(nums[i] > nums[i + 1])
        {
            mn = min(mn, nums[i + 1]);
            mx = max(mx, nums[i]);
        }
        else
        {
            mn = min(mn, nums[i]);
            mx = max(mx, nums[i + 1]);
        }
    }
    
    return {mn,mx};
}

int main()
{
    vector<int> arr{-1, -2, 3, 2, 4, 1, 0 , 6 ,6};
    vector<int> mandm = minandmax(arr); 
    for(int i = 0 ; i < mandm.size(); i++)
    {
        cout << mandm[i] << endl;
    }
}