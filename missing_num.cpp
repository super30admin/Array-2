// Time complexity-O(n)
// space complexity O(1);
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// we are trying to leverage the state change technique
// iterate over the array
// for each element go to its position in the array assuming the array was sorted and make it negative
// iterate the second time and check which of the elements arent negative


#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        int len = nums.size();
        vector<int>result;
        for(int i=0;i< len;i++){
            int index= abs(nums[i])-1;
           nums[index]= nums[index] >0 ? -nums[index] : nums[index];
        }
        for(int i =0;i <len;i++){
           if (nums[i]> 0){
               result.push_back(i+1);
           }
        }
        return result;
    }
};