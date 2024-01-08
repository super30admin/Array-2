// Time Complexity : O(N)

// Space Complexity : O(1)

// Did this code successfully run on Leetcode : YES

// Appoarch: Altering the same array by making the index value negative
// and returning the remaining positive values. 

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        vector<int> result;
        int n = nums.size();
        for(int i=0;i<n;i++){
            int idx = abs(nums[i]) - 1;
            if(nums[idx] > 0){
                nums[idx] *= -1;
            }
        }
            for(int i=0;i<n;i++){
                if(nums[i] > 0){
                    result.push_back(i+1);
                }
                else{
                    nums[i] *= -1;
                }
            }      
        return result;
    }
};