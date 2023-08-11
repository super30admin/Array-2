/*

// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
Concept of temporary state change
Make the index associated with the value negative. 
and traverse the complete array
The element index that is non-negative is the missing number

*/




#include<iostream>
#include<vector>

using namespace std;

class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        vector<int> arr;
        int n{static_cast<int>(nums.size())};
        for(int i{};i<n;++i){
            int val = abs(nums.at(i));
            if(nums.at(val-1)>0){
                nums.at(val-1) *=-1;
            }
        }
        for(int i{};i<n;++i){
            if(nums.at(i)>0){
                arr.push_back(i+1);
            }
        }
        return arr;
    }
};