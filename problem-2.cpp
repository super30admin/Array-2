// Maximum and minimum of an array using minimum number of comparisons
// Time Complexity : O(n)
// Space Complexity : O(1)
// Three line explanation of solution in plain english

/* 
    minimizing number of comparisions by comparing peer to peer elements.
*/


// Your code here along with comments explaining your approach
#include<bits/stdc++.h>
using namespace std;
vector<int> minAndMax(vector<int>& nums)
{

    int n = nums.size(), minnum = nums[0], maxnum = nums[0];
    for(int i = 1; i < n; i+=2)
    {
        if(nums[i] < nums[i-1])
        {
            maxnum =  max(maxnum, nums[i-1]);
            minnum = min(minnum, nums[i]);
        }
        else{
            maxnum =  max(maxnum, nums[i]);
            minnum = min(minnum, nums[i - 1]);
        }
    }
    return {maxnum,minnum};
}
