// Problem - Find all numbers disappeared
//  Time Complexity : O(n)
//  Space Complexity : O(1)
//  Did this code successfully run on Leetcode : Yes
//  Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. Here we multiply -1 to the element we have already seen by getting the idx
// from the abs(nums[i]) - 1
// 2. We use existing array as an hashset and do not use any extra space
// 3. We go through the array from 0 to n,  and check if number is greater than
// 0, that means the number i+1 is one of the numbers that have disappeared and
// was not seen in the array

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  vector<int> findDisappearedNumbers(vector<int> &nums) {
    int n = (int)nums.size();
    for (int i = 0; i < n; i++) {
      int idx = abs(nums[i]) - 1;
      if (nums[idx] > 0) {
        nums[idx] = -1 * nums[idx];
      }
    }

    vector<int> res;
    for (int i = 0; i < n; i++) {
      if (nums[i] > 0) {
        res.push_back(i + 1);
      }
    }
    return res;
  }
};
