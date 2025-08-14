#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We compare the first one or two elements to initialize the min and max.
Then we scan the array in pairs and update min and max by comparing within the pair first.
This reduces the number of comparisons to about 1.5 * n, making it efficient.
*/
class Solution{
public:
    vector<int> findMinAndMax(vector<int>& nums) {
        int n = nums.size();
        int min_val, max_val;
        int i;

        if (n % 2 == 0) {
            if (nums[0] < nums[1]) {
                min_val = nums[0];
                max_val = nums[1];
            } else {
                min_val = nums[1];
                max_val = nums[0];
            }
            i = 2;
        } else {
            min_val = max_val = nums[0];
            i = 1;
        }

        while (i < n - 1) {
            if (nums[i] < nums[i + 1]) {
                min_val = std::min(min_val, nums[i]);
                max_val = std::max(max_val, nums[i + 1]);
            } else {
                min_val = std::min(min_val, nums[i + 1]);
                max_val = std::max(max_val, nums[i]);
            }
            i += 2;
        }

        return {min_val, max_val};
    }
};
